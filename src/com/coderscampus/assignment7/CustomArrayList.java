package com.coderscampus.assignment7;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	private Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {

		increaseArraySizeIfNeeded();
		items[size] = item;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		if (size == items.length) {
			increaseArraySizeIfNeeded();

			// Shift all existing items to the right
			for (int i = size; i > index; i--) {
				items[i] = items[i - 1];
			}

			// Set the new item at the specified index
			items[index] = item;
			size++;
			return true;
		} else {
			// Handle other cases
			return false;
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");

		}
		@SuppressWarnings("unchecked")
		T element = (T) items[index];
		return element;
	}

	private void increaseArraySizeIfNeeded() {
		if (size == items.length) {
			Object[] newItems = Arrays.copyOf(items, items.length * 2);
			items = newItems;
		}
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
