package dots_lab;
import java.io.PrintStream;

public class SolutionDots {
	public static final int MAXPATTERN = 16;
	private DrawingBoard board;

	public SolutionDots(DrawingBoard paramDrawingBoard) {
		this.board = paramDrawingBoard;
	}

	public void draw(int paramInt) {
		int l = 8;
		int i1 = 8;

		this.board.clear();
		this.board.setTitle("Pattern " + paramInt);

		assert ((paramInt >= 1) && (paramInt <= 16));
		int i;
		int j;
		int k;
		switch (paramInt) {
			case 1 :
				for (i = 0;; ++i) {
					if (i >= i1)
						return;
					for (j = 0; j < l; ++j)
						this.board.bigDot(i, j);
				}
			case 2 :
				for (j = 0;; ++j) {
					if (j >= l)
						return;
					for (i = 0; i < i1; ++i)
						this.board.bigDot(i, j);
				}
			case 3 :
				for (i = 0;; ++i) {
					if (i >= i1)
						return;
					for (j = 0; j < i; ++j)
						this.board.bigDot(i, j);
				}
			case 4 :
				for (i = 0;; ++i) {
					if (i >= i1)
						return;
					for (j = i; j < l; ++j)
						this.board.bigDot(i, j);
				}
			case 5 :
				for (i = 1;; ++i) {
					if (i >= i1)
						return;
					for (j = 1; j <= l - i; ++j)
						this.board.bigDot(i, j);
				}
			case 6 :
				for (i = 0;; ++i) {
					if (i >= i1)
						return;
					for (j = l; j > l - 1 - i; --j)
						this.board.bigDot(i, j);
				}
			case 7 :
				for (i = 0;; ++i) {
					if (i > i1)
						return;
					this.board.bigDot(i, i);
				}
			case 8 :
				for (i = 0; i <= i1; ++i)
					this.board.bigDot(i, i);
				for (i = 0;; ++i) {
					if (i > i1)
						return;
					this.board.bigDot(i, l - i);
				}
			case 9 :
				for (j = 0;; ++j) {
					if (j >= l)
						return;
					for (i = j; i < i1 - j; ++i)
						this.board.bigDot(i, j);
				}
			case 10 :
				for (j = 0; j < l; ++j)
					for (i = j; i < i1 - j; ++i)
						this.board.bigDot(i, j);
				int i2 = 2;
				for (j = l / 2;; ++j) {
					if (j >= l)
						return;
					for (i = i1 - j - 1; i < i1 - j - 1 + i2; ++i)
						this.board.bigDot(i, j);
					i2 += 2;
				}
			case 11 :
				for (j = 0; j < l; ++j)
					this.board.bigDot(0, j);
				for (i = 0; i < i1; ++i)
					this.board.bigDot(i, l - 1);
				for (j = l - 1; j >= 0; --j)
					this.board.bigDot(i1 - 1, j);
				for (i = i1 - 1;; --i) {
					if (i <= 0)
						return;
					this.board.bigDot(i, 0);
				}
			case 12 :
				for (k = 0;; ++k) {
					if (k >= i1 / 2)
						return;
					for (j = k; j < l - k; ++j) {
						this.board.bigDot(k, j);
					}
					for (i = k; i < i1 - k; ++i) {
						this.board.bigDot(i, l - 1 - k);
					}
					for (j = l - 1 - k; j >= k; --j) {
						this.board.bigDot(i1 - 1 - k, j);
					}
					for (i = i1 - 1 - k; i > k; --i)
						this.board.bigDot(i, k);
				}
			case 13 :
				for (i = 0;; ++i) {
					if (i >= i1)
						return;
					j = i - 1;
					for (k = 0; k < 3; ++k) {
						if ((j >= 0) && (j < l))
							this.board.bigDot(i, j);
						++j;
					}
				}
			case 14 :
				this.board.bigDot(0, 1);
				for (i = 1; i < i1; ++i) {
					for (j = i - 1; j <= i + 1; ++j) {
						if ((i != i1 - 1) || (j <= l - 1))
							this.board.bigDot(i, j);
					}
				}
				this.board.bigDot(0, 0);
				break;
			case 15 :
				for (i = 0; i < i1; ++i)
					this.board.bigDot(i, i);
				for (i = 0;; ++i) {
					if (i >= i1 - 1)
						return;
					this.board.bigDot(i, i + 1);
				}
			case 16 :
				for (k = 0;; ++k) {
					if (k >= 8)
						return;
					for (i = 0; i < i1 - k; ++i)
						this.board.bigDot(i, i + k);
				}
			default :
				System.out.println("This one hasn't been done yet.");
		}
	}
}