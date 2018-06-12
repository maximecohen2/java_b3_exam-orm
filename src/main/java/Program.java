public class Program {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager("dataManager");

        //dataManager.addCentreRecherche("Ariane", "Bordeaux");

        CentreRecherche centreAriane = dataManager.findCentreRecherche("Ariane");

        //dataManager.addAuteur("Maxime Cohen", "Programmation", null);
        //dataManager.addAuteur("Cédric", "Programmation", centreAriane);

        dataManager.close();
    }
}
