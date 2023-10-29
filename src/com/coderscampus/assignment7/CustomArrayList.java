package com.coderscampus.assignment7;

public class CustomArrayList<T> implements CustomList<T> {
	private Object[] items;
	private int size;

	public CustomArrayList() {
		items = new Object[10];
		size = 0;
	}

	public boolean add(T item) {
		increaseArraySizeIfNeeded();
		items[size] = item;
		size++;
		return true;
	}

	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		if (size == items.length) {
			increaseArraySizeIfNeeded();
		}

		if (index == size) {
			items[size] = item;
			size++;
			return true;
		}

		for (int i = size; i > index; i--) {
			items[i] = items[i - 1];
		}

		items[index] = item;
		size++;
		return true;
	}

	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		return (T) items[index];
	}

	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		@SuppressWarnings("unchecked")
		T removedItem = (T) items[index];

		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}

		items[size - 1] = null; // Clear the last element
		size--;
		return removedItem;
	}

	private void increaseArraySizeIfNeeded() {
		if (size >= items.length) {
			Object[] newArray = new Object[size * 2];
			System.arraycopy(items, 0, newArray, 0, size);
			items = newArray;
		}
	}
}
