package net.GameV;

import java.util.Random;
import java.util.Scanner;

public class RookScissorPaper {

	public static enum Item {
		ROCK("Камень(🗿)") {
			@Override
			public boolean isWin(Item item) {
				return item == SCISSOR/* || item == WELL */;
			}
		},
		SCISSOR("Ножницы(✂️)") {
			@Override
			public boolean isWin(Item item) {
				return item == PAPER;
			}
		},
		PAPER("Бумага(🧻)") {
			@Override
			public boolean isWin(Item item) {
				return item == ROCK/* || item == BRICK */;
			}
//		},
//		BRICK("Кирпич(🧱)") {
//			@Override
//			public boolean isWin(Item item) {
//				return item == ROCK || item == SCISSOR;
//			}
//		},
//		WELL("Колодец(🌊)") {
//			@Override
//			public boolean isWin(Item item) {
//				return item == BRICK || item == PAPER;
//			}
		};

		private final String name;

		private Item(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public abstract boolean isWin(Item item);

		public static Item getItemByIndex(int index) {
			return Item.values()[index];
		}

	}

	public static void main(String[] args) {
		Item[] items = Item.values();
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			System.out.println(i + 1 + " -> " + item.getName());
		}
		System.out.println();

		int bot = new Random().nextInt(items.length);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите ваш ход (1 - " + items.length + "): ");
		int player = scanner.nextInt() - 1;

		scanner.close();

		Item botItem = Item.getItemByIndex(bot);
		Item playerItem = Item.getItemByIndex(player);

		System.out.println("Бот: " + botItem.getName());
		System.out.println("Ты: " + playerItem.getName());
		System.out.println();

		if (playerItem == botItem) {
			System.out.println("Ничья");

		} else if (playerItem.isWin(botItem)) {
			System.out.println(playerItem.getName() + " бъёт " + botItem.getName());
			System.out.println("Ты выиграл!!!");

		} else {
			System.out.println(botItem.getName() + " бъёт " + playerItem.getName());
			System.out.println("Ты проиграл программе");
		}
	}
}
