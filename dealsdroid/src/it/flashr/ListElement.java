/*
 ******************************************************************************
 * Parts of this code sample are licensed under Apache License, Version 2.0   *
 * Copyright (c) 2011, Android Open Handset Alliance. All rights reserved.    *
 *                                                                            *
 * Except as noted, this code sample is offered under a modified BSD license. *
 * Copyright (C) 2011, Motorola Mobility, Inc. All rights reserved.           *
 *                                                                            *
 * For more details, see MOTODEV_Studio_for_Android_LicenseNotices.pdf        *
 * in your installation folder.                                               *
 ******************************************************************************
 */

package it.flashr;

import java.io.Serializable;

/**
 * Element which belongs to each row of the List of this view.
 */
class ListElement implements Serializable {

	private static final long serialVersionUID = -1494059051539426231L;
	String text;
	Integer imageId;

	/**
	 * Always create the object with a text and an image.
	 * 
	 * @param text
	 *            Text of the {@link ListElement}.
	 * @param imageId
	 *            Image identifier of the {@link ListElement}.
	 */
	public ListElement(String text, Integer imageId) {
		this.text = text;
		this.imageId = imageId;
	}

	/**
	 * Get the Text.
	 * 
	 * @return Return the Text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the Text.
	 * 
	 * @param text
	 *            Text to be set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get the Image identifier.
	 * 
	 * @return Return the Image identifier.
	 */
	public Integer getImageId() {
		return imageId;
	}

	/**
	 * Set the Image identifier.
	 * 
	 * @param imageId
	 *            Image Identifier to be set.
	 */
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	/**
	 * Here we consider two {@link ListElement}s to be equal when they have the
	 * same text field.
	 */
	@Override
	public boolean equals(Object element) {
		return element != null && element instanceof ListElement
				&& this.text != null && ((ListElement) element).text != null
				&& ((ListElement) element).text.equals(text);
	}

	@Override
	public int hashCode() {
		return text != null ? text.length() * 3 : 4;
	}
}