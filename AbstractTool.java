import java.awt.Point;

public abstract class AbstractTool implements Tool {
	
	public String getName() {
		return name;
	}
	
	protected AbstractTool(ScribbleCanvas canvas, String name) {
		this.canvas = canvas;
		this.name = name;
	}
	
	protected ScribbleCanvas canvas;
	protected String name;
}
