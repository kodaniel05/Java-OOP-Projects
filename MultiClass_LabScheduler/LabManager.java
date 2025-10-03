/**
 * Project 02 --TimeKeeper
 *
 * This program helps you find your CS lab
 *
 * @author Katie O'Daniel,
 *
 * @version June 15, 2023
 *
 */
public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;
    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }
    public Lab getLabOne() {
        return labOne;
    }
    public Lab getLabTwo() {
        return labTwo;
    }
    public Lab getLabThree() {
        return labThree;
    }
    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }
    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }
    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }

    public int calculateTotalCapacity() {
        int totalCapacity = 0;
        totalCapacity += labOne.getCapacity() * 2;
        totalCapacity += labTwo.getCapacity() * 2;
        totalCapacity += labThree.getCapacity() * 2;
        return totalCapacity;
    }

    public double calculateTotalUtilization() {
        double totalUtilization = 0.0;

        double labOneUtilization = ((double) labOne.getMorning().getEnrollment()
                + (double) labOne.getAfternoon().getEnrollment()) / (2 * labOne.getCapacity());
        totalUtilization += labOneUtilization;

        double labTwoUtilization = ((double) labTwo.getMorning().getEnrollment()
                + (double) labTwo.getAfternoon().getEnrollment()) / (2 * labTwo.getCapacity());
        totalUtilization += labTwoUtilization;

        double labThreeUtilization = ((double) labThree.getMorning().getEnrollment()
                + (double) labThree.getAfternoon().getEnrollment()) / (2 * labThree.getCapacity());
        totalUtilization += labThreeUtilization;

        double averageUtilization = totalUtilization / 3;
        return Math.round(averageUtilization * 100.0) / 100.0;
    }


    public int calculateAvailableSeats() {
        int availableSeats = 0;

        if (labOne.getMorning().getEnrollment() > 0) {
            availableSeats += labOne.getCapacity() - labOne.getMorning().getEnrollment();
        } else {
            availableSeats += labOne.getCapacity();
        }

        if (labOne.getAfternoon().getEnrollment() > 0) {
            availableSeats += labOne.getCapacity() - labOne.getAfternoon().getEnrollment();
        } else {
            availableSeats += labOne.getCapacity();
        }

        if (labTwo.getMorning().getEnrollment() > 0) {
            availableSeats += labTwo.getCapacity() - labTwo.getMorning().getEnrollment();
        } else {
            availableSeats += labTwo.getCapacity();
        }

        if (labTwo.getAfternoon().getEnrollment() > 0) {
            availableSeats += labTwo.getCapacity() - labTwo.getAfternoon().getEnrollment();
        } else {
            availableSeats += labTwo.getCapacity();
        }

        if (labThree.getMorning().getEnrollment() > 0) {
            availableSeats += labThree.getCapacity() - labThree.getMorning().getEnrollment();
        } else {
            availableSeats += labThree.getCapacity();
        }

        if (labThree.getAfternoon().getEnrollment() > 0) {
            availableSeats += labThree.getCapacity() - labThree.getAfternoon().getEnrollment();
        } else {
            availableSeats += labThree.getCapacity();
        }

        return availableSeats;
    }

    public String listReservedLabs() {
        String result = "Lab One\n";
        if (labOne.getMorning().getEnrollment() > 0) {
            result += "Morning: Reserved\n";
        }
        if (labOne.getAfternoon().getEnrollment() > 0) {
            result += "Afternoon: Reserved\n";
        }
        if (result.equals("Lab One\n")) {
            result += "No Reservations\n";
        }

        result += "\nLab Two\n";
        if (labTwo.getMorning().getEnrollment() > 0) {
            result += "Morning: Reserved\n";
        }
        if (labTwo.getAfternoon().getEnrollment() > 0) {
            result += "Afternoon: Reserved\n";
        }
        if (result.endsWith("Lab Two\n")) {
            result += "No Reservations\n";
        }

        result += "\nLab Three\n";
        if (labThree.getMorning().getEnrollment() > 0) {
            result += "Morning: Reserved\n";
        }
        if (labThree.getAfternoon().getEnrollment() > 0) {
            result += "Afternoon: Reserved\n";
        }
        if (result.endsWith("Lab Three\n")) {
            result += "No Reservations\n";
        }

        return result;
    }
    public String listAvailableLabs() {
        String result = "Lab One\n";
        if (labOne.getMorning().getEnrollment() == 0) {
            result += "Morning: Available\n";
        }
        if (labOne.getAfternoon().getEnrollment() == 0) {
            result += "Afternoon: Available\n";
        }
        if (result.equals("Lab One\n")) {
            result += "No Availabilities\n";
        }

        result += "\nLab Two\n";
        if (labTwo.getMorning().getEnrollment() == 0) {
            result += "Morning: Available\n";
        }
        if (labTwo.getAfternoon().getEnrollment() == 0) {
            result += "Afternoon: Available\n";
        }
        if (result.endsWith("Lab Two\n")) {
            result += "No Availabilities\n";
        }

        result += "\nLab Three\n";
        if (labThree.getMorning().getEnrollment() == 0) {
            result += "Morning: Available\n";
        }
        if (labThree.getAfternoon().getEnrollment() == 0) {
            result += "Afternoon: Available\n";
        }
        if (result.endsWith("Lab Three\n")) {
            result += "No Availabilities\n";
        }

        return result;
    }

    public String addReservation(String location, String time, String name, int enrollment) {
        if (location.equals(labOne.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labOne.getCapacity() - enrollment >= 0) {
                    if (labOne.getMorning().getEnrollment() > 0) {
                        return "Error. Invalid time.";
                    }
                    Session session = new Session(name , enrollment);
                    labOne.setMorning(session);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            }
            if (time.equalsIgnoreCase("Afternoon")) {
                if (labOne.getCapacity() - enrollment >= 0) {
                    if (labOne.getAfternoon().getEnrollment() > 0) {
                        return "Error. Invalid time.";
                    }
                    Session session = new Session(name , enrollment);
                    labOne.setAfternoon(session);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }

            } else {
                return "Error. Invalid time";
            }
        }
        if (location.equals(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labTwo.getCapacity() - enrollment >= 0) {
                    if (labTwo.getMorning().getEnrollment() > 0) {
                        return "Error. Invalid time.";
                    }
                    Session session = new Session(name , enrollment);
                    labTwo.setMorning(session);
                    return "Reservation added!";
                }
                return "Error. Capacity exceeded";

            }
            if (time.equalsIgnoreCase("Afternoon")) {
                if (labTwo.getCapacity() - enrollment >= 0) {
                    if (labTwo.getAfternoon().getEnrollment() > 0) {
                        return "Error. Invalid time.";
                    }
                    Session session = new Session(name , enrollment);
                    labTwo.setAfternoon(session);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }

            } else {
                return "Error. Invalid time";
            }
        }
        if (location.equals(labThree.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labThree.getCapacity() - enrollment >= 0) {
                    if (labThree.getMorning().getEnrollment() > 0) {
                        return "Error. Invalid time.";
                    }
                    Session session = new Session(name , enrollment);
                    labThree.setMorning(session);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }
            }
            if (time.equalsIgnoreCase("Afternoon")) {
                if (labThree.getCapacity() - enrollment >= 0) {
                    if (labThree.getAfternoon().getEnrollment() > 0) {
                        return "Error. Invalid time.";
                    }
                    Session session = new Session(name, enrollment);
                    labThree.setAfternoon(session);
                    return "Reservation added!";
                } else {
                    return "Error. Capacity exceeded";
                }

            } else {
                return "Error. Invalid time";
            }
        }
        return "Error. Invalid location";
    }

    public String removeReservation(String location, String time) {
        if (location.equals(labOne.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labOne.getMorning().getEnrollment() > 0) {
                    Session session = new Session("", 0);
                    labOne.setMorning(session);
                    return "Reservation removed!";
                } else {
                    return "Error. Invalid time";
                }
            }
            if (time.equalsIgnoreCase("Afternoon")) {
                if (labOne.getAfternoon().getEnrollment() > 0) {
                    Session session = new Session("", 0);
                    labOne.setAfternoon(session);
                    return "Reservation removed!";
                } else {
                    return "Error. Invalid time";
                }
            }
            return "Error. Invalid time";
        }
        if (location.equals(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labTwo.getMorning().getEnrollment() > 0) {
                    Session session = new Session("", 0);
                    labTwo.setMorning(session);
                    return "Reservation removed!";
                } else {
                    return "Error. Invalid time";
                }
            }
            if (time.equalsIgnoreCase("Afternoon")) {
                if (labTwo.getAfternoon().getEnrollment() > 0) {
                    Session session = new Session("", 0);
                    labTwo.setAfternoon(session);
                    return "Reservation removed!";
                } else {
                    return "Error. Invalid time";
                }
            }
            return "Error. Invalid time";
        }
        if (location.equals(labThree.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labThree.getMorning().getEnrollment() > 0) {
                    Session session = new Session("", 0);
                    labThree.setMorning(session);
                    return "Reservation removed!";
                } else {
                    return "Error. Invalid time";
                }
            }
            if (time.equalsIgnoreCase("Afternoon")) {
                if (labThree.getAfternoon().getEnrollment() > 0) {
                    Session session = new Session("", 0);
                    labThree.setAfternoon(session);
                    return "Reservation removed!";
                } else {
                    return "Error. Invalid time";
                }
            }
            return "Error. Invalid time";
        }

        return "Error. Invalid location";
    }



    public String modifyReservation(String location, String time, String name, int enrollment) {
        if (location.equals(labOne.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labOne.getMorning().getEnrollment() > 0) {
                    if (labOne.getCapacity() - enrollment >= 0) {
                        Session session = new Session(name, enrollment);
                        labOne.setMorning(session);
                        return "Reservation modified!";
                    } else {
                        return "Error. Capacity exceeded";
                    }
                } else {
                    return "Error. Invalid time.";
                }
            } else if (time.equalsIgnoreCase("Afternoon")) {
                if (labOne.getAfternoon().getEnrollment() > 0) {
                    if (labOne.getCapacity() - enrollment >= 0) {
                        Session session = new Session(name, enrollment);
                        labOne.setAfternoon(session);
                        return "Reservation modified!";
                    } else {
                        return "Error. Capacity exceeded";
                    }
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Invalid time";
            }
        } else if (location.equals(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labTwo.getMorning().getEnrollment() > 0) {
                    if (labTwo.getCapacity() - enrollment >= 0) {
                        Session session = new Session(name, enrollment);
                        labTwo.setMorning(session);
                        return "Reservation modified!";
                    } else {
                        return "Error. Capacity exceeded";
                    }
                } else {
                    return "Error. Invalid time.";
                }
            } else if (time.equalsIgnoreCase("Afternoon")) {
                if (labTwo.getAfternoon().getEnrollment() > 0) {
                    if (labTwo.getCapacity() - enrollment >= 0) {
                        Session session = new Session(name, enrollment);
                        labTwo.setAfternoon(session);
                        return "Reservation modified!";
                    } else {
                        return "Error. Capacity exceeded";
                    }
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Invalid time";
            }
        } else if (location.equals(labThree.getLocation())) {
            if (time.equalsIgnoreCase("Morning")) {
                if (labThree.getMorning().getEnrollment() > 0) {
                    if (labThree.getCapacity() - enrollment >= 0) {
                        Session session = new Session(name, enrollment);
                        labThree.setMorning(session);
                        return "Reservation modified!";
                    } else {
                        return "Error. Capacity exceeded";
                    }
                } else {
                    return "Error. Invalid time.";
                }
            } else if (time.equalsIgnoreCase("Afternoon")) {
                if (labThree.getAfternoon().getEnrollment() > 0) {
                    if (labThree.getCapacity() - enrollment >= 0) {
                        Session session = new Session(name, enrollment);
                        labThree.setAfternoon(session);
                        return "Reservation modified!";
                    } else {
                        return "Error. Capacity exceeded";
                    }
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Invalid time";
            }
        } else {
            return "Error. Invalid location";
        }
    }

    @Override
    public String toString() {
        return "LabManager{" + labOne + ", " + labTwo + ", " + labThree + "}";
    }





}
