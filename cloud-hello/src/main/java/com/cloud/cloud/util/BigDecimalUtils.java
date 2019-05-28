package com.cloud.cloud.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工具类
 *
 */
public class BigDecimalUtils {
	// BigDecimal 乘法 : Double x, Double y
	public static BigDecimal bigDecimalMul(Double x, Double y, int scale) {
		return new BigDecimal(x).multiply(new BigDecimal(y)).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 乘法 : BigDecimal x, BigDecimal y
	public static BigDecimal bigDecimalMul(BigDecimal x, BigDecimal y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y.doubleValue());
		return temp_x.multiply(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 乘法 : BigDecimal x, Double y
	public static BigDecimal bigDecimalMul(BigDecimal x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.multiply(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 乘法 : BigDecimal x, Long y
	public static BigDecimal bigDecimalMul(BigDecimal x, Long y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.multiply(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 除法 : BigDecimal x, BigDecimal y, int scale
	public static BigDecimal bigDecimalDiv(BigDecimal x, BigDecimal y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y.doubleValue());
		if (temp_y.compareTo(new BigDecimal(0)) == 0)
			return new BigDecimal(0);
		return temp_x.divide(temp_y, scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 除法 : Double x, BigDecimal y, int scale
	public static BigDecimal bigDecimalDiv(Double x, BigDecimal y, int scale) {
		BigDecimal temp_x = new BigDecimal(x);
		BigDecimal temp_y = new BigDecimal(y.doubleValue());
		if (temp_y.compareTo(new BigDecimal(0)) == 0)
			return new BigDecimal(0);
		return temp_x.divide(temp_y, scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 除法 : Double x, BigDecimal y, int scale
	public static BigDecimal bigDecimalDiv(Double x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal(x);
		BigDecimal temp_y = new BigDecimal(y);
		if (temp_y.compareTo(new BigDecimal(0)) == 0)
			return new BigDecimal(0);
		return temp_x.divide(temp_y, scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 除法 : BigDecimal x, Double y, int scale
	public static BigDecimal bigDecimalDiv(BigDecimal x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		if (temp_y.compareTo(new BigDecimal(0)) == 0)
			return new BigDecimal(0);
		return temp_x.divide(temp_y, scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 除法 : BigDecimal x, Long y, int scale
	public static BigDecimal bigDecimalDiv(BigDecimal x, Long y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		if (temp_y.compareTo(new BigDecimal(0)) == 0)
			return new BigDecimal(0);
		return temp_x.divide(temp_y, scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 加法 : BigDecimal x, BigDecimal y
	public static BigDecimal bigDecimalAdd(BigDecimal x, BigDecimal y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y.doubleValue());
		return temp_x.add(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 加法 : Double x, Double y
	public static BigDecimal bigDecimalAdd(Double x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal(x);
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.add(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 加法 : BigDecimal x, Double y
	public static BigDecimal bigDecimalAdd(BigDecimal x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.add(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 加法 : BigDecimal x, Long y
	public static BigDecimal bigDecimalAdd(BigDecimal x, Long y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.add(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 减法 : BigDecimal x, BigDecimal y
	public static BigDecimal bigDecimalSub(BigDecimal x, BigDecimal y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y.doubleValue());
		return temp_x.subtract(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 减法 : BigDecimal x, BigDecimal y
	public static BigDecimal bigDecimalSub(Double x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal("" + x.doubleValue());
		BigDecimal temp_y = new BigDecimal("" + y.doubleValue());
		return temp_x.subtract(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 减法 : BigDecimal x, BigDecimal y
	public static BigDecimal bigDecimalSub(Double x, BigDecimal y, int scale) {
		BigDecimal temp_x = new BigDecimal(x);
		BigDecimal temp_y = new BigDecimal(y.doubleValue());
		return temp_x.subtract(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 减法 : BigDecimal x, Double y
	public static BigDecimal bigDecimalSub(BigDecimal x, Double y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.subtract(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	// BigDecimal 减法 : BigDecimal x, Long y
	public static BigDecimal bigDecimalSub(BigDecimal x, Long y, int scale) {
		BigDecimal temp_x = new BigDecimal(x.doubleValue());
		BigDecimal temp_y = new BigDecimal(y);
		return temp_x.subtract(temp_y).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	/**************************************************************************
	 * 四舍五入
	 * 
	 * @param value
	 * @param scale
	 * @return
	 */
	public static BigDecimal round(BigDecimal value, int scale) {

		double scaleA = Math.pow(10, Double.valueOf(scale));
		return BigDecimalUtils.bigDecimalDiv(BigDecimal.valueOf(Math.round(value.doubleValue() * scaleA)), scaleA, scale);
	}

	public static double discount(BigDecimal discount) {
		discount = discount.divide(new BigDecimal("100"));
		return discount.doubleValue();
	}

	/**
	 * 贴现利息计算
	 * 
	 * @param draftAmt
	 * @param dscDays
	 * @param rateInt
	 *            利率%
	 * @return
	 */
	public static double dscInterCompute(String draftAmt, String dscDays, String rateInt) {
		BigDecimal amt = new BigDecimal(draftAmt);
		BigDecimal dscDay = new BigDecimal(dscDays);
		BigDecimal rate = BigDecimalUtils.bigDecimalDiv(new BigDecimal(rateInt), new BigDecimal("100"), 10);
		BigDecimal data = amt.multiply(dscDay).multiply(rate.divide(new BigDecimal("360"), 20, BigDecimal.ROUND_HALF_UP));
		return data.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static String getNumber(String prefix) {
		String number = prefix + DateUtils.getDS(new Date());
		return number;
	}

	public static BigDecimal getDscYieldRate(BigDecimal sumAmt, Double setAmt, Integer tenorDays) {
		BigDecimal a = BigDecimalUtils.bigDecimalDiv(sumAmt, setAmt, 20);
		a = BigDecimalUtils.bigDecimalSub(a, new BigDecimal("1"), 20);
		a = BigDecimalUtils.bigDecimalMul(a, new BigDecimal("360"), 20);
		a = BigDecimalUtils.bigDecimalDiv(a, new BigDecimal("" + tenorDays), 20);
		return a;
	}
}
