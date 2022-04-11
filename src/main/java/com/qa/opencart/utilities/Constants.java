package com.qa.opencart.utilities;

import java.util.Arrays;
import java.util.List;

public class Constants
{
	public static final String LOGINPAGE_TITLE="Account Login";
	public static final String LOGINPAGE_URL ="https://demo.opencart.com/index.php?route=account/login";
	public static final String ACCOUNTSPAGE_TITLE="My Account";
	public static final List<String> EXPECTED_SECTION_LIST=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	public static final Object MACBOOK_PRODUCT_COUNT = 3;
	public static final int MACBOOK_IMG_COUNT = 4;
	public static final String REGISTER_SUCCESS_MESSAGE ="Your Account Has Been Created!";
	public static final String REGISTER_SHEETNAME = "register";
	public static final String PRODUT_SHEETNAME ="product";
}
