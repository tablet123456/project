package primitives;

/**
 * sdf jaskdfjhdskj hsdfkj hdsf
 * @author tzvibloom
 *
 */
public class Coordinate {
	//private static final double EPSILON = 0.0000001;
	private double _coordinate;
	public static final Coordinate ZERO = new Coordinate(0.0);

	/********** Constructors ***********/
	public Coordinate(double coord) {
		// if it too close to zero make it zero
		_coordinate = (getExp(coord) < ACCURACY) ? 0.0 : coord;
	}

	public Coordinate(Coordinate other) {
		_coordinate = other._coordinate;
	}
	
	public static boolean isZero(double number) {
		   return getExp(number) < ACCURACY;
	}

	/************** Getters/Setters *******/
	public double get() {
		return _coordinate;
	}

	/*************** Admin *****************/
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		
		// With the following trick we will be able
		// to test a number for being almost 0 or 0 as
		// follows:
		// if (Coordinate.ZERO.equals(number) ...
		if (obj instanceof Double)
			return subtract((double)obj) == 0.0;
			
		if (!(obj instanceof Coordinate)) return false;
		
		Coordinate other = (Coordinate) obj;
		return subtract(other._coordinate) == 0.0;
	}

	@Override
	public String toString() {
		return "" + _coordinate;
	}

	/************** Operations ***************/
	public Coordinate subtract(Coordinate other) {
		return new Coordinate(subtract(other._coordinate));
	}

	public Coordinate add(Coordinate other) {
		return new Coordinate(add(other._coordinate));
	}
	
	public Coordinate scale(double num) {
		return new Coordinate(_scale(num));
	}

	public Coordinate multiply(Coordinate other) {
		return new Coordinate(_scale(other._coordinate));
	}
	/************** Helpers ***************/
	// It is binary, equivalent to ~1/1,000,000 in decimal (6 digits)
	private static final int ACCURACY = -20;

	static // double store format (bit level): seee eeee eeee (1.)mmmm � mmmm
	// 1 bit sign, 11 bits exponent, 53 bits (52 stored) normalized mantissa
	// the number is m+2^e where 1<=m<2
	// NB: exponent is stored "normalized" (i.e. always positive by adding 1023)
	int getExp(double num) {
		// 1. doubleToRawLongBits: "convert" the stored number to set of bits
		// 2. Shift all 52 bits to the right (removing mantissa)
		// 3. Zero the sign of number bit by mask 0x7FF
		// 4. "De-normalize" the exponent by subtracting 1023
		return (int) ((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
	}

	private double subtract(double other) {
		int otherExp = getExp(other);
		int thisExp = getExp(_coordinate);

		// if other is too small relatively to our coordinate
		// return the original coordinate
		if (otherExp - thisExp < ACCURACY)
			return _coordinate;

		// if our coordinate is too small relatively to other
		// return negative of other coordinate
		if (thisExp - otherExp < ACCURACY)
			return -other;

		double result = _coordinate - other;
		// if the result is too small tell that it is zero
		int resultExp = getExp(result);
		return resultExp < ACCURACY ? 0.0 : result;
	}

	private double add(double other) {
		int otherExp = getExp(_coordinate);
		int thisExp = getExp(_coordinate);

		// if other is too small relatively to our coordinate
		// return the original coordinate
		if (otherExp - thisExp < ACCURACY)
			return _coordinate;

		// if our coordinate is too small relatively to other
		// return other coordinate
		if (thisExp - otherExp < ACCURACY)
			return other;

		double result = _coordinate + other;
		// if the result is too small tell that it is zero
		int resultExp = getExp(result);
		return resultExp < ACCURACY ? 0.0 : result;
	}
	
	private double _scale(double num) {
		int deltaExp = getExp(num - 1);
		return deltaExp < ACCURACY ? _coordinate : _coordinate * num;
	}

}
