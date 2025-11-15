System.out.println("=====================================");
System.out.println("      Space Expedition WitVerse      ");
System.out.println("=====================================");
System.out.println("Hello Astronaut! Welcome to your space adventure.\n TO CONTINUE, ENTER YOUR NAME: ");

Scanner scanner = new Scanner(System.in);
String name = scanner.nextLine();

System.out.println("Welcome to Space Expedition WitVerse.\n 
Your mission is to navigate through the stars and explore new worlds!\n
Good luck, " + name + "!\n Type 'start' to begin your adventure.");