package by.tms.lesson28.onl30.jsp.everything;

public class KeeperConstants {
    public static final String LF = "\n";
    public static final String SEPARATOR = ";";
    public static final String SLAGE = "/";
    public static final String BEGINNING_WORK_MESSAGE_TEMPLATE = "'%s' has started working";
    public static final String ENDING_WORK_MESSAGE_TEMPLATE = "'%s' completed the operation";
    public static final String LOGGER_MESSAGE_TEMPLATE = "%s -- %s" + LF;
    public static final String ERROR_TEMPLATE = "ERROR: %s";
    public static final String ERROR_IO_FILE_TEMPLATE = "invalid path to %s";
    public static final String ERROR_ON_OPERAND_TEMPLATE = "one of the operands is not a number";
    public static final String ERROR_ON_TYPE_OPERATION_TEMPLATE = "the specified operation is not being processed";
    public static final String INVALID_OPERATION = "invalid operation";
    public static final String RESPONSE_TEMPLATE = "result operation: %s";
    public static final String USERS_CSV_FILE = "C:\\Users\\123\\IdeaProjects\\lesson28-onl30-jsp\\src\\main\\resources\\users.csv";
//    public static final String LOGIN_PASSWORD_STORAGE = "C:\\Users\\123\\IdeaProjects\\lesson-26-30-onl-webCalculator\\src\\main\\java\\login_password.csv";
    public static final String USERS_CSV_FORMAT_TEMPLATE = "%s" + SEPARATOR + "%s" + SEPARATOR + "%s" + SEPARATOR + "%s" + LF;
    public static final String DATE_TIME_LOGGER_TEMPLATE = "dd/MM/yyyy HH:mm:ss";
    public static final String HOME_PAGE = "/pages/home.jsp";
    public static final String REGISTRATION_PAGE = "/pages/registration.jsp";
    public static final String LOGIN_PAGE = "/pages/login.jsp";
    public static final String REGISTRATION_PATH = "/user/registration";
    public static final String LOGIN_PATH = "/user/login";
    public static final String LOGOUT_PATH = "/user/logout";
    // todo сделать присвоение из файла настройки
    public static final boolean IS_PERFORM_LOGGING = true;
}
