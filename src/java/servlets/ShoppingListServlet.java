/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilities.Item;

/**
 *
 * @author 677571
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null || action == "") {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            if (action.equalsIgnoreCase("logout")) {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null || action.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (action.equals("register")) {
            String username = request.getParameter("username");
            if (username == null || username.equals("")) {
                request.setAttribute("errorMessage", "Please enter a username");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else {
                session.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        } else if (action.equals("add")) {
            ArrayList shoppingList = (ArrayList) session.getAttribute("shoppingList");
            if (shoppingList == null) {
                session.setAttribute("shoppingList", new ArrayList());
                shoppingList = (ArrayList) session.getAttribute("shoppingList");
                String newItem = request.getParameter("newItem");
                Item item = new Item(newItem);
                if (newItem == null || newItem.equals("")) {
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                } else {
                    shoppingList.add(item);
                    session.setAttribute("shoppingList", shoppingList);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
            } else {
                shoppingList = (ArrayList) session.getAttribute("shoppingList");
                String newItem = request.getParameter("newItem");
                Item item = new Item(newItem);
                if (newItem == null || newItem.equals("")) {
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                } else {
                    shoppingList.add(item);
                    session.setAttribute("shoppingList", shoppingList);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
            }
        } else if (action.equals("delete")) {
            String[] items = request.getParameterValues("listItems");
            ArrayList itemList = (ArrayList) session.getAttribute("shoppingList");
            if (items != null) {
                for (String string : items) {
                    for (int i = 0; i < itemList.size(); i++) {
                        Item item = (Item) itemList.get(i);
                        if (item.getValue().equals(string)) {
                            itemList.remove(item);
                        }
                    }
                }
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }
}
