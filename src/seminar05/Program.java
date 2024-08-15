package seminar05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("8. Удалить модель");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.println("Пожалуйста, выберите пункт меню.");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.println("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 2:
                            editor3D.saveProject();
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                            break;
                        case 7:
                            System.out.printf("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            }
                            else {
                                System.out.println("Номер модели указан не корректно.");
                            }
                            break;
                        case 8:
                            System.out.printf("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.removeModel(modelNo);
                            }
                            else {
                                System.out.println("Номер модели указан не корректно.");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный номер меню.");
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
}

/**
 * UI (User Interface)
 */
class Editor3D implements UILayer {

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccessLayer;
    private DataBase dataBase;



    private void initialize() {
        dataBase = new EditorDatabase(projectFile);
        databaseAccessLayer = new EditorDatabaseAccess(dataBase);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccessLayer);
    }
    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {
        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %s\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }
    private void checkProjectFile() {
        if (projectFile == null) {
            throw new RuntimeException("Файл проекта не определен.");
        }
    }

    @Override
    public void saveProject() {
        // Предусловие
        checkProjectFile();

        dataBase.save();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> model3DS = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < model3DS.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(model3DS.get(i));
            model3DS.get(i).getTextures().forEach(t -> System.out.printf("\t%s\n", t));
        }
    }

    @Override
    public void printAllTextures() {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for(int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d mc.\n", endTime);
    }

    @Override
    public void renderModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d mc.\n", endTime);
    }

    @Override
    public void removeModel(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректно.");
        businessLogicalLayer.removeModel(models.get(i));
        System.out.println("Модель удалена!");
    }
}

/**
 * Интерфейс UI
 */
interface UILayer {
    void openProject(String fileName);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);
    void removeModel(int i);
}

/**
 * Реализация Business Logical Layer
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private Random random = new Random();
    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public void renderModel(Model3D model3D) {
        processRender(model3D);
    }

    @Override
    public void renderAllModels() {
        getAllModels().forEach(m -> processRender(m));
    }

    @Override
    public void removeModel(Model3D model3D) {
        databaseAccess.removeEntity(model3D);
    }


    private void processRender(Model3D model3D) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * Интерфейс BLL (Business Logical Layer)
 */
interface BusinessLogicalLayer {
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
    void renderModel(Model3D model3D);
    void renderAllModels();
    void removeModel(Model3D model3D);
}

/**
 * Реализация DAC
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final DataBase editorDatabase;

    public EditorDatabaseAccess(DataBase editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                textures.add((Texture) entity);
            }
        }
        return textures;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }
}

/**
 * Интерфейс DAC
 */
interface DatabaseAccess {
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
}

/**
 * DataBase
 */
class EditorDatabase implements DataBase {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры и т. д)
    }

    @Override
    public void save() {
        //TODO: Сохранение текущего состояния всех сущностей проекта

    }

    @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }
}

/**
 * Интерфейс БД
 */
interface DataBase {
    void load();
    void save();
    Collection<Entity> getAll();
}

/**
 * 3Д Модель
 */
class Model3D implements Entity {

    private static int counter = 10000;
    private int id;
    {
        id = ++counter;
    }

    private Collection<Texture> textures = new ArrayList<>();

    public Model3D() {}

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public int getId() {
        return 0;
    }
    @Override
    public String toString() {
        return String.format("3DModel #%s", id);
    }
}

/**
 * Текстура
 */
class Texture implements Entity {
    private static int counter = 50000;
    private int id;
    {
        id = ++counter;
    }


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }
}

/**
 * Сущность
 */
interface Entity {
    int getId();
}

/**
 * Файл проекта
 */
class ProjectFile {
    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public ProjectFile(String fileName) {
        this.fileName = fileName;
        //TODO: Загрузка настроек проекта из файла

        setting1 = 1;
        setting2 = "...";
        setting3 = false;
    }

    public String getFileName() {
        return fileName;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }
}