package eecs2030MultypleImageViewer;

import java.awt.MediaTracker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class ViewerModel {

	private static final ImageIcon EMPTY_IMAGE = new ImageIcon();
	private int currentImage;
	private List<ImageIcon> images;

	public ViewerModel() {
		this.images = new ArrayList<>();
		this.currentImage = -1;
	}

	/**
	 * @return the current image if the model has one or more images or an empty
	 *         image otherwise
	 */
	public ImageIcon getCurrentImage() {
		int length = images.size();
		if (length == 0) {
			return EMPTY_IMAGE;
		} else {
			return images.get(currentImage);
		}
	}

	public ImageIcon getNextImage() {
		if (images.size() == 0) {
			return EMPTY_IMAGE;
		} else if ((images.size() - 1) == currentImage) {
			return images.get(currentImage);
		} else {
			currentImage++;
			return images.get(currentImage);
		}
	}

	public ImageIcon getPreviousImage() {
		ImageIcon icon = EMPTY_IMAGE;
		if (currentImage > 0) {
			this.currentImage--;
		}
		if (this.currentImage >= 0) {
			icon = this.images.get(currentImage);
		}
		return icon;

	}

	/**
	 * Clear the images held by the model.
	 */
	public void clearImages() {
		this.currentImage = -1;
		this.images.clear();
	}

	public void openImages(File[] files) {
		List<ImageIcon> icons = new ArrayList<>();

		for (File f : files) {

			ImageIcon icon = new ImageIcon(f.getAbsolutePath());
			if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
				icons.add(icon);
			}

		}
		if (this.currentImage < 0 && icons.size() > 0) {
			this.currentImage = 0;
		}
		this.images.addAll(icons);
	}

}
