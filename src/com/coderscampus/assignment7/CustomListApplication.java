package com.coderscampus.assignment7;

public class CustomListApplication {

	public static void main(String[] args) {

		CustomList<Integer> futbolistas = new CustomArrayList<Integer>();
		
		int maxElements = 100;
		for (int i = 0; i < maxElements; i++) {
			futbolistas.add(i);
			System.out.println(futbolistas.getSize());
		}
		System.out.println("-------");
		System.out.println(futbolistas.get(44));
		System.out.println(futbolistas.get(7));
		System.out.println(futbolistas.get(41));
		System.out.println(futbolistas.get(33));



		
	}

}
