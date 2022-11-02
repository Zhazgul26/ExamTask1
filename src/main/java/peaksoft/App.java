package peaksoft;


import peaksoft.daoImpl.CarDaoImpl;
import peaksoft.daoImpl.PersonDaoImpl;
import peaksoft.daoImpl.SocialDaoImpl;
import peaksoft.entity.Car;
import peaksoft.entity.Person;
import peaksoft.entity.SocialMedia;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        mainMethod();
    }

    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to save car");
        System.out.println("Press 2 to get car by ID");
        System.out.println("Press 3 to get all cars");
        System.out.println("Press 4 to delete car by ID");
        System.out.println("Press 5 to get car by person ID");
        System.out.println("Press 6 to get car by person name");
        System.out.println();
        System.out.println("Press 7 to save person");
        System.out.println("Press 8 to update person");
        System.out.println("Press 9 to find person by ID");
        System.out.println("Press 10 to get person by name");
        System.out.println("Press 11 to delete person by ID");
        System.out.println("Press 12 to get all person");
        System.out.println();
        System.out.println("Press 13 to save social media");
        System.out.println("Press 14 to update social media");
        System.out.println("Press 15 to get social media by ID");
        System.out.println("Press 16 to get all social media");
        System.out.println("Press 17 to delete social media by ID");
        System.out.println("Press 18 to get social media by name");
        System.out.println("Press 19 to get assign person to social media");
        System.out.println("---------------------------------------------");
    }

    static void mainMethod() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        CarDaoImpl carDao = new CarDaoImpl();
        PersonDaoImpl personDao = new PersonDaoImpl();
        SocialDaoImpl socialMediaDao = new SocialDaoImpl();


        String number = "null";
        while (!number.equals("x")) {
            commands();
            System.out.println("Choose a command: ");
            number = scanner2.nextLine();
            try {
                if (Character.isDigit(number.charAt(0))) {
                    switch (number) {
                        case "1" -> {
                            Scanner scanner11 = new Scanner(System.in);
                            Car car = new Car();
                            System.out.println("Write car model");
                            car.setCarModel(scanner11.nextLine());
                            System.out.println("Write person id");
                            Long personID = scanner2.nextLong();
                            Person person = car.convertPerson(personID);
                            car.setPerson(person);
                            carDao.saveCar(car);
                        }
                        case "2" -> {
                            System.out.println("Write car's ID:");
                            Long id = scanner.nextLong();
                            System.out.println(carDao.getCarById(id));
                        }
                        case "3" -> {
                            for (Car i : carDao.getAllCars()) {
                                System.out.println(i);
                            }
                        }
                        case "4" -> {
                            System.out.println("Write car's ID:");
                            Long id = scanner1.nextLong();
                            carDao.deleteCarById(id);
                        }
                        case "5" -> {
                            Scanner scanner5 = new Scanner(System.in);
                            System.out.println("Write person ID:");
                            Long id = scanner5.nextLong();
                            System.out.println(carDao.getCarsByPersonId(id));
                        }
                        case "6" -> {
                            Scanner scanner6 = new Scanner(System.in);
                            System.out.println("Write person name:");
                            String name = scanner6.nextLine();
                            System.out.println(carDao.getCarsByPersonName(name));
                        }
                        case "7" -> {
                            Scanner scanner7 = new Scanner(System.in);
                            Person person = new Person();
                            System.out.println("Write name:");
                            person.setName(scanner7.nextLine());
                            System.out.println("Write age:");
                            person.setAge(scanner2.nextInt());
                            personDao.savePerson(person);
                        }
                        case "8" -> {
                            Scanner scanner8 = new Scanner(System.in);
                            Person person = new Person();
                            System.out.println("Write name:");
                            person.setName(scanner8.nextLine());
                            System.out.println("Write age:");
                            person.setAge(scanner2.nextInt());
                            System.out.println("Which person do you want update? Write ID:");
                            Long id = scanner.nextLong();
                            personDao.updatePerson(id, person);
                        }
                        case "9" -> {
                            System.out.println("Write person's ID");
                            Long id = scanner.nextLong();
                            System.out.println(personDao.getPerson(id));
                        }
                        case "10" -> {
                            Scanner scanner10 = new Scanner(System.in);
                            System.out.println("Write person name: ");
                            String name = scanner10.nextLine();
                            System.out.println(personDao.getPersonByName(name));
                        }
                        case "11" -> {
                            System.out.println("Write ID to delete:");
                            Long id = scanner.nextLong();
                            personDao.deletePersonId(id);
                        }
                        case "12" -> {
                            for (Person i : personDao.getAllPerson()) {
                                System.out.println(i);
                            }
                        }
                        case "13" -> {
                            Scanner scanner14 = new Scanner(System.in);
                            System.out.println("Write social media name");
                            SocialMedia socialMedia1 = new SocialMedia(scanner14.nextLine());
                            socialMediaDao.saveMedia(socialMedia1);
                        }
                        case "14" -> {
                            Scanner scanner13 = new Scanner(System.in);
                            System.out.println("Which social media do you want update write id");
                            Long id = scanner13.nextLong();
                            System.out.println("Write social media name");
                            SocialMedia socialMedia1 = new SocialMedia(scanner.nextLine());
                            socialMediaDao.updateSocialMedia(id, socialMedia1);
                        }
                        case "15" -> {
                            System.out.println("Write media ID:");
                            Long id = scanner1.nextLong();
                            System.out.println(socialMediaDao.getSocialMedia(id));
                        }
                        case "16" -> {
                            for (SocialMedia i : socialMediaDao.getAllMedia()) {
                                System.out.println(i);
                            }
                        }
                        case "17" -> {
                            Scanner scanner17 = new Scanner(System.in);
                            System.out.println("Write media id");
                            Long id = scanner17.nextLong();
                            socialMediaDao.deleteSocialMedia(id);
                        }
                        case "18" -> {
                            Scanner scanner18 = new Scanner(System.in);
                            System.out.println("Write social media name:");
                            String name = scanner18.nextLine();

                            System.out.println(socialMediaDao.getSocialMediaByName(name));
                        }
                        case "19" -> {
                            Scanner scanner19 = new Scanner(System.in);
                            System.out.println("Write person id:");
                            Long personId = scanner19.nextLong();
                            System.out.println("Write social media id:");
                            Long mediaId = scanner1.nextLong();
                            socialMediaDao.assignPersonToMedia(personId, mediaId);
                        }
                    }
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("It is not a button");
            }
        }
    }
}
