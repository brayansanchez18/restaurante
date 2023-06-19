package domain;

public enum TipoAcompanamiento {
  PAPAS_FRANCESAS(0);

  private final double price;

  private TipoAcompanamiento(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
