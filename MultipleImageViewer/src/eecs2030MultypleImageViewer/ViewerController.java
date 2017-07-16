package eecs2030MultypleImageViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;

public class ViewerController implements ActionListener {

	private ViewerModel model;
	private ViewerView view;

	public ViewerController() {
	}

	public void setModel(ViewerModel model) {
		this.model = model;
	}

	public void setView(ViewerView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if (action.equals(ViewerView.OPEN)) {
			this.view.makeFileChooser();
			File[] files = this.view.getFilesToOpen();
			this.model.openImages(files);
			ImageIcon icon = this.model.getCurrentImage();
			this.view.setImage(icon);
		} else if (action.equals(ViewerView.CLEAR)) {
			this.model.clearImages();
			ImageIcon icon = this.model.getCurrentImage();
			this.view.setImage(icon);
		} else if (action.equals(ViewerView.PREVIOUS)) {
			ImageIcon icon = this.model.getPreviousImage();
			this.view.setImage(icon);
		} else if (action.equals(ViewerView.NEXT)) {
			ImageIcon icon = this.model.getNextImage();
			this.view.setImage(icon);
		}

	}

}
