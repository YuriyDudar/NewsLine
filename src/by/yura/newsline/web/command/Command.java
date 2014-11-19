package by.yura.newsline.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class to add commands
 */
abstract public class Command {

    public abstract void execute (HttpServletRequest request, HttpServletResponse response);
}
