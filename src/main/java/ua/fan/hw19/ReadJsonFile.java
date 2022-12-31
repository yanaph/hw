package ua.fan.hw19;

import ua.fan.hw19.model.Box;
import ua.fan.hw19.model.Cargo;
import ua.fan.hw19.model.MaxLiftingCapacity;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadJsonFile {
    public static void main(String[] args){
        Path jsonFile = Path.of("src/main/java/ua/fan/hw19/resources/box.json");
        Box box;
        try {
            box = getBoxFromJson(jsonFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(box);
    }

    private static Box getBoxFromJson(Path jsonFile) throws IOException {
        Box box = new Box();
        String content = Files.readString(jsonFile, StandardCharsets.US_ASCII);

        box.setFrom(searchValue(content, "\"from\":.\"(.*?)\""));
        box.setMaterial(searchValue(content, "\"material\":.\"(.*?)\""));
        box.setColor(searchValue(content, "\"color\":.\"(.*?)\""));

        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        maxLiftingCapacity.setUnit(searchValue(content, "\"unit\":.\"(.*?)\""));
        maxLiftingCapacity.setValue(Integer.parseInt(searchValue(content, "\"value\":.(\\d*)")));
        box.setMaxLiftingCapacity(maxLiftingCapacity);

        Cargo cargo = new Cargo();
        cargo.setName(searchValue(content, "\"name\":.\"(.*)\""));
        cargo.setClassification(searchValue(content, "\"class\":.\"(.*)\""));
        box.setCargo(cargo);

        LocalDateTime date = LocalDateTime.parse(searchValue(content, "\"delivery-date\":.\"(.*?)\""));
        box.setDeliveryDate(date);
        return box;
    }

    private static String searchValue(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        String result = "";
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

}
