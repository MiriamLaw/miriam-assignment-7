package com.coderscampus.assignment7;

public class CustomListApplication {

	public static void main(String[] args) {

		CustomList<Integer> futbolistas = new CustomArrayList<>();
		
		for (int i = 0; i < 51; i++) {
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
