package grupoaravia.gynlog;

import grupoaravia.gynlog.view.TelaSlash;

/**
 * Grupo Aravia
 *
 * @author <a href="https://github.com/Alexsanei">Alexsanei</a>
 * @author <a href="https://github.com/Caio4breu">Caio4breu</a>
 * @author <a href="https://github.com/Nomscodes">Nomscodes</a>
 * @author <a href="https://github.com/GabrielNaokiUT">GabrielNaokiUT</a>
 * @author <a href="https://github.com/wyllianmn">wyllianmn</a>
 */

public class GynLog {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaSlash().setVisible(true);
        });
    }
}