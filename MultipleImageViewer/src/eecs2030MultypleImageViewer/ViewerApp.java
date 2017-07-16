package eecs2030MultypleImageViewer;

public class ViewerApp {

	private ViewerApp() {
	}

	public static void main(String[] args) {
		ViewerModel model = new ViewerModel();
		ViewerController controller = new ViewerController();
		ViewerView view = new ViewerView(controller);
		controller.setModel(model);
		controller.setView(view);
		view.setVisible(true);
	}

}
