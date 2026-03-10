package grupoaravia.gynlog;
/**
 *
 * @author Caio 4breu
 */

import grupoaravia.gynlog.view.TelaSlash;

public class GynLog {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaSlash().setVisible(true);
        });
    }
}