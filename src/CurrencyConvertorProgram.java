import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

public class CurrencyConvertorProgram extends JFrame implements ActionListener {
    // components
    // JButtons
    private final JButton convertButton= new JButton("convert");
    private final JLabel inputLabel = new JLabel("enter the money:");
    private final JLabel resultLabel = new JLabel("result:");
    private final JTextField inputTextField = new JTextField();
    private final JTextField resultTextField = new JTextField();
    private final JComboBox<String>  comboBox = new JComboBox<>(new String[] {
            "dinarTunisien->euro",
            "euro->dinarTunisien",
            "dinarTunisien->dinarKoweitien",
            "dinarKoweitien->dinarTunisien"
    });
    private final JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

    public CurrencyConvertorProgram() {
        // title
        super("Currency Convertor V1.0");

        // init
        convertButton.setFocusable(false);
        resultTextField.setEditable(false);

        // adding components to the panel
        panel.add(inputLabel);
        panel.add(inputTextField);
        panel.add(resultLabel);
        panel.add(resultTextField);
        panel.add(comboBox);
        panel.add(convertButton);

        // adding ActionListeners to the components
        convertButton.addActionListener(this);

        // adding components to the frame
        this.add(panel);

        // setup
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 150);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            resultTextField.setText("");

            String selectedItem = (String) comboBox.getSelectedItem();
            String[] units = selectedItem.split("->");

            String c1 = units[0];
            String c2 = units[1];

            try {
                double input = Double.parseDouble(inputTextField.getText());

                switch (selectedItem) {
                    case "dinarTunisien->euro" -> {
                        input *= 0.3;
                    }
                    case "euro->dinarTunisien" -> {
                        input /= 0.3;
                    }
                    case "dinarTunisien->dinarKoweitien" -> {
                        input *= 0.098;
                    }
                    case "dinarKoweitien->dinarTunisien" -> {
                        input /= 0.098;
                    }
                }

                resultTextField.setText(String.format("%.3f %s", input, c2));
                inputTextField.setText("");
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(this,
                    "error\n" + ne.getMessage(),
                    "error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
