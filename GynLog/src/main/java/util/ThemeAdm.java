package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class ThemeAdm {
    
    public enum Theme {
        LIGHT,
        DARK
    }
    
    
    private static final Preferences prefs = Preferences.userNodeForPackage(ThemeAdm.class);
    private static final String PREF_KEY = "app.theme";
    private static Theme temaAtual = Theme.LIGHT;
    
    // Cores modo CLARO --------------------------------------------------------
    private static final Color LIGHT_BACKGROUND = hex("#F4F4F8"); // background geral
    private static final Color LIGHT_PANEL = hex("#FFFFFF"); // cards e painéis
    private static final Color LIGHT_PRIMARY = hex("#7B4BF0"); // roxo principal BOTÕES
    private static final Color LIGHT_SECONDARY = hex("#F09C4A"); // laranja
    private static final Color LIGHT_TERTIARY = hex("#5B705D"); // verde acinzentado
    private static final Color LIGHT_TEXT = hex("#000000"); // texto geral
    private static final Color LIGHT_BUTTON_TEXT = hex("#FFFFFF"); // texto em botões
    private static final Color LIGHT_TABLE_TEXT = hex("#000000"); // texto na JTable
    private static final Color LIGHT_TABLE_SELECTION = hex("#E0D7FF"); // seleção da JTable
    private static final Color LIGHT_FOCUS = hex("#7B4BF0"); // borda de foco
    
    // Cores modo ESCURO -------------------------------------------------------
    private static final Color DARK_BACKGROUND = hex("#101014");
    private static final Color DARK_PANEL = hex("#181820");
    private static final Color DARK_PRIMARY = hex("#73649B");
    private static final Color DARK_SECONDARY = hex("#F09C4A");
    private static final Color DARK_TERTIARY = hex("#2D3A31");
    private static final Color DARK_TEXT = hex("#FFFFFF");
    private static final Color DARK_BUTTON_TEXT = hex("#FFFFFF");
    private static final Color DARK_TABLE_TEXT = hex("#EAEAEA");
    private static final Color DARK_TABLE_SELECTION = hex("#2A2440");
    private static final Color DARK_FOCUS = hex("#7364FF");
    
    // Getters e Setters -------------------------------------------------------
    public static Theme getTheme() { return temaAtual; }
    public static void setTheme(Theme theme) { temaAtual = theme; saveTheme(theme); }
    public static Color getBackgroundColor() { return temaAtual == Theme.LIGHT ? LIGHT_BACKGROUND : DARK_BACKGROUND; }
    public static Color getPanelColor() { return temaAtual == Theme.LIGHT ? LIGHT_PANEL : DARK_PANEL; }
    public static Color getPrimaryColor() { return temaAtual == Theme.LIGHT ? LIGHT_PRIMARY : DARK_PRIMARY; }
    public static Color getSecondaryColor() { return temaAtual == Theme.LIGHT ? LIGHT_SECONDARY : DARK_SECONDARY; }
    public static Color getTertiaryColor() { return temaAtual == Theme.LIGHT ? LIGHT_TERTIARY : DARK_TERTIARY; }
    public static Color getTextColor() { return temaAtual == Theme.LIGHT ? LIGHT_TEXT : DARK_TEXT; }
    public static Color getButtonTextColor() {
return temaAtual == Theme.LIGHT ? LIGHT_BUTTON_TEXT : DARK_BUTTON_TEXT;
}
    public static Color getTableTextColor() { return temaAtual == Theme.LIGHT ? LIGHT_TABLE_TEXT : DARK_TABLE_TEXT; }
    public static Color getTableSelectionColor() { return temaAtual == Theme.LIGHT ? LIGHT_TABLE_SELECTION : DARK_TABLE_SELECTION; }
    public static Color getFocusBorderColor() { return temaAtual == Theme.LIGHT ? LIGHT_FOCUS : DARK_FOCUS; }
   
    // Conversão de hex string para color
    private static Color hex(String hex) {
        return Color.decode(hex);
    }
    
    // Toggle de tema (útil para botões de alternância)
    public static void toggleTheme() {
        setTheme(temaAtual == Theme.LIGHT ? Theme.DARK : Theme.LIGHT);
    }
    
    // Percistencia! Registrar a escolha anterior ----------------------------------------
    private static void saveTheme(Theme theme) {
        prefs.put(PREF_KEY, theme.name());
    }
    
    private static Theme loadSavedTheme() {
        String v = prefs.get(PREF_KEY, Theme.LIGHT.name());
        try {
            return Theme.valueOf(v);
        } catch (Exception e) {
            return Theme.LIGHT;
        }
    }
    
    // Aplicação do tema em componentes Swing
    public static void applyTheme(Window window) {
        if (window == null) return;
        SwingUtilities.invokeLater(() -> {
            if (window instanceof javax.swing.JFrame frame) {
                frame.getContentPane().setBackground(getBackgroundColor());
            } else {
                window.setBackground(getBackgroundColor());
            }
            
            applyToComponentHierarchy(window);
            window.revalidate();
            window.repaint();
        });
        
        if (window instanceof javax.swing.JFrame frame) {
            frame.getContentPane().setBackground(getBackgroundColor());
        }

    }
    
    private static void applyToComponentHierarchy(Component comp) {
        applyToSingleComponent(comp);
        
        if (comp instanceof java.awt.Container cont) {
            for (Component child : cont.getComponents()) {
                applyToComponentHierarchy(child);
            }
        }
    }
    
    private static void applyToSingleComponent(Component c) {
        if (c instanceof JPanel p) {
            if (p.getParent() instanceof javax.swing.JRootPane) {
                p.setBackground(getBackgroundColor());
                return;
            }
            
//            if (p.getParent() instanceof javax.swing.JRootPane) {
//                // Painel principal (fundo) - usa cor de background
//                p.setBackground(getBackgroundColor());
//            } else {
//                // Painéis internos - usa cor de painel (cards)
//                p.setBackground(getPanelColor());
//            }
//            p.setForeground(getTextColor());
        }
        
        if (c instanceof JLabel lbl) {
            lbl.setForeground(getTextColor());
        }
        
        if (c instanceof JButton btn) {
            btn.setBackground(getPrimaryColor());
            btn.setForeground(getButtonTextColor());
            btn.setFocusPainted(false);
            btn.setFont(btn.getFont().deriveFont(Font.PLAIN));
        }
        
        if (c instanceof JToggleButton tbtn) {
            tbtn.setBackground(getPanelColor());
            tbtn.setForeground(getTextColor());
        }
        
        if (c instanceof javax.swing.JComboBox<?> combo) {
            combo.setBackground(getPanelColor());
            combo.setForeground(getTextColor());
            try {
                javax.swing.ListCellRenderer<?> renderer = combo.getRenderer();
                if (renderer instanceof javax.swing.JLabel) {
                    ((javax.swing.JLabel) renderer).setForeground(getTextColor());
                }
            } catch (Exception ignored) {}
        }
        
        if (c instanceof JTable table) {
            table.setBackground(getPanelColor());
            table.setForeground(getTableTextColor());
            table.setSelectionBackground(getTableSelectionColor());
            table.setSelectionForeground(getButtonTextColor());
            table.getTableHeader().setBackground(getPrimaryColor());
            table.getTableHeader().setForeground(getButtonTextColor());
            table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD));
        }
        
        if (c instanceof JScrollPane sp) {
            sp.getViewport().setBackground(getPanelColor());
        }
        
        if (c instanceof JComponent jc) {
            // borda de foco simples (pode ser expandida para usar BorderFactory) ???
            jc.putClientProperty("JComponent.focusedBackground", getFocusBorderColor());
        }
        
        // componentes genéricos: tenta aplicar cor de texto
        if (!(c instanceof JLabel) && !(c instanceof JButton) && !(c instanceof JTable) && !(c instanceof JPanel)) {
            try {
                c.setForeground(getTextColor());
            } catch (Exception ignored) {
                
            }
        }
        
        if (c instanceof javax.swing.JTextField txt) {
            txt.setBackground(getPanelColor());
            txt.setForeground(getTextColor());
            txt.setCaretColor(getTextColor());

            // Essencial para placeholders VOLTAREM
            txt.repaint();
        }
        
    }
    
    // Registra a ultima escolha do usuario
    public static void addRememberOnClose(Window window) {
        if (window == null) return;
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveTheme(temaAtual);
            }
        });
    }
    
    public static void toggleAndApply(Window window) {
        toggleTheme();
        applyTheme(window);
    }
    
}
