package com.poly;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.poly.form.MainForm;
import com.poly.form.nhanvien.entity.Login;
import com.poly.form.nhanvien.view.LoginForm;
import com.poly.form.sanpham.view.ThongKeSanPham;
import com.poly.form.thongke.view.ViewSanPham;
import com.poly.menu.Menu;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class Application extends javax.swing.JFrame {

    private static Application app;
    private final MainForm mainForm;
    private final LoginForm loginForm;
    private String username;
    private Login loggedInUser;
    public static Menu menu;

    public Application() {
        initComponents();
         this.menu = new Menu();
        this.setResizable(false);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        loginForm = new LoginForm();
        mainForm = new MainForm();
        setContentPane(loginForm);
        Notifications.getInstance().setJFrame(this);
    }

    public static void showForm(Component component) {
        component.applyComponentOrientation(app.getComponentOrientation());
        app.mainForm.showForm(component);
    }

    public static void login(Login loggedInUser) {
        app.mainForm.setLoggedInUser(loggedInUser);
        FlatAnimatedLafChange.showSnapshot();
        app.mainForm.showForm(new ViewSanPham());
        app.setContentPane(app.mainForm);
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        app.mainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();

        // Chuyển thông tin đăng nhập cho đối tượng Menu
        app.menu.setLoggedInUser(loggedInUser.getId(), loggedInUser.getUsername());
    }

    public static void logout() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.loginForm);
        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.loginForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    public static void setSelectedMenu(int index, int subIndex) {
        app.mainForm.setSelectedMenu(index, subIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            app = new Application();
            //  app.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            app.setVisible(true);
        });
    }

    private class menu {

        public menu() {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
