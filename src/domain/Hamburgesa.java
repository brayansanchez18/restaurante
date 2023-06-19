package domain;

import javax.swing.JOptionPane;

public class Hamburgesa {
  private TipoHamburgesa tipoHamburgesa;
  private TipoBebida tipoBebida;
  private AcompanamientoExtra acompanamientoExtra;
  private boolean papasFrancesas;
  private boolean extra;
  private boolean bebida;

  public Hamburgesa() {
    SeleccionarTipoHamburgesa();
    SeleccionarTipoAcompanamiento();
    SeleccionarAcompanamientoExtra();
    SeleccionarBebida();
  }

  private void SeleccionarBebida() {
    this.bebida = JOptionPane.showConfirmDialog(null, "desea acompanar su orden con una bebida?", "seleccionar bebida",
        JOptionPane.YES_NO_OPTION) == 0;

    if (bebida) {
      String out = "Selecciona su bebida: \n1-agua simple $0.00 \n2-agua fresca $15.00 \n3-refresco embotellado $20.00 \n4-cafe $18.00 \n5-te $18.00";

      int seleccion = Integer
          .parseInt(JOptionPane.showInputDialog(null, out, "tipo de bebida",
              JOptionPane.QUESTION_MESSAGE));

      switch (seleccion) {
        case 1:
          this.tipoBebida = TipoBebida.AGUA_SIMPLE;
          break;
        case 2:
          this.tipoBebida = TipoBebida.AGUA_FRESCA;
          break;
        case 3:
          this.tipoBebida = TipoBebida.EMBOTELLADO;
          break;
        case 4:
          this.tipoBebida = TipoBebida.CAFE;
          break;
        case 5:
          this.tipoBebida = TipoBebida.TE;
          break;
      }
    }
  }

  private void SeleccionarAcompanamientoExtra() {
    this.extra = JOptionPane.showConfirmDialog(null, "desea acompanar su hamburgesa con un complemento extra?",
        "complemento", JOptionPane.YES_NO_OPTION) == 0;

    if (extra) {
      String out = "Selecciona el tipo de complemento: \n1-queso +$5.00  \n2-tocino +$7.00 \n3-pepinollos +$6.50 \n4-sin complemento";

      int seleccion = Integer
          .parseInt(JOptionPane.showInputDialog(null, out, "tipo de complemento", JOptionPane.QUESTION_MESSAGE));

      switch (seleccion) {
        case 1:
          this.acompanamientoExtra = AcompanamientoExtra.QUESO;
          break;
        case 2:
          this.acompanamientoExtra = AcompanamientoExtra.TOCINO;
          break;
        case 3:
          this.acompanamientoExtra = AcompanamientoExtra.PEPINILLOS;
          break;
        case 4:
          this.acompanamientoExtra = AcompanamientoExtra.SIN_COMPLENTO;
          break;
      }
    }
  }

  private void SeleccionarTipoAcompanamiento() {
    // preguntamos si lleva o no papas a la francesa
    this.papasFrancesas = JOptionPane.showConfirmDialog(null, "LLeva papas a la francesa?", "papas a la francesa",
        JOptionPane.YES_NO_OPTION) == 0;
  }

  private void SeleccionarTipoHamburgesa() {
    String out = "Selecciones el tipo de hamburgesa: \n1- Sencilla $10.00 \n2- Doble $15.00 \n3- Triple $20.00";

    int seleccion = Integer
        .parseInt(JOptionPane.showInputDialog(null, out, "tipo de hamburgesa", JOptionPane.QUESTION_MESSAGE));

    switch (seleccion) {
      case 1:
        this.tipoHamburgesa = TipoHamburgesa.SENCILLA;
        break;
      case 2:
        this.tipoHamburgesa = TipoHamburgesa.DOBLE;
        break;
      case 3:
        this.tipoHamburgesa = TipoHamburgesa.TRIPLE;
        break;
    }
  }

  // @Override
  public void printDetails() {
    String out = "";
    double costo = 0;

    switch (this.tipoHamburgesa) {
      case SENCILLA:
        out += "La hamburges es sencilla\n";
        break;
      case DOBLE:
        out += "La hamburges es doble\n";
        break;
      case TRIPLE:
        out += "La hamburges es triple\n";
        break;
    }

    costo += this.tipoHamburgesa.getPrice();

    if (this.papasFrancesas) {
      out += "la amburgesa ira acompanada de papas a la francesa\n";
    }

    if (this.extra) {
      switch (this.acompanamientoExtra) {
        case QUESO:
          out += "Complemento: queso\n";
          break;
        case TOCINO:
          out += "complemento: tocino\n";
          break;
        case PEPINILLOS:
          out += "complemento: pepinillos\n";
          break;
        case SIN_COMPLENTO:
          out += "complemento: sin complemento\n";
          break;
      }
      costo += this.acompanamientoExtra.getPrice();
    }

    if (this.bebida) {
      switch (this.tipoBebida) {
        case AGUA_SIMPLE:
          out += "bebida: agua simple\n";
          break;
        case AGUA_FRESCA:
          out += "bebida: agua fresca\n";
          break;
        case EMBOTELLADO:
          out += "bebida: refresco\n";
          break;
        case CAFE:
          out += "bebida: cafe\n";
          break;
        case TE:
          out += "bebida: te\n";
          break;
      }
      costo += this.tipoBebida.getPrice();
    }

    out += "el costo final de la hamburgesa es de: $%.2f";
    JOptionPane.showMessageDialog(null, String.format(out, costo), "resuman de la orden", JOptionPane.PLAIN_MESSAGE);

  }
}