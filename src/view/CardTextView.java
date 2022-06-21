package view;

import java.io.IOException;

/**
 * This class is used to display the flashcards.
 */
public class CardTextView implements TextView {
  private final Appendable out;
  private final StringBuilder text;
  private int letter;

  /**
   * Constructor for the CardTextView.
   */
  public CardTextView() {
    this(System.out);
  }

  /**
   * Constructor for the CardTextView.
   *
   * @param appendable The appendable to use.
   */
  public CardTextView(Appendable appendable) {
    this.text = new StringBuilder();
    this.out = appendable;
  }

  @Override
  public void render(String answer) throws IOException {
    try {
      out.append(answer);
    } catch (IOException e) {
      throw new IOException("Could not render answer.", e);
    }
  }
}
