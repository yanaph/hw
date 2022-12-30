package ua.fan.module2.util;

import ua.fan.module2.exception.NotEnoughDataException;
import ua.fan.module2.model.Device;
import ua.fan.module2.model.Invoice;
import ua.fan.module2.model.Telephone;
import ua.fan.module2.model.Television;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FileHandling {
    private final HashMap<String, Integer> headerMap = new HashMap<>();

    public List<Device> readFile(String fileName) {
        ArrayList<Device> catalogueOfDevices = new ArrayList<>();
        int lineIndex = 0;
        try (BufferedReader bufferedReader = createFileBufferReader(fileName)) {
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                readHeader(line);
                while ((line = bufferedReader.readLine()) != null) {
                    lineIndex++;
                    try {
                        catalogueOfDevices.add(createDeviceFromLine(line));
                    } catch (NotEnoughDataException e) {
                        System.out.println(e.getMessage() + " Line index is " + lineIndex);
                    }
                }
            } else {
                throw new NotEnoughDataException("File is empty!");
            }
        } catch (IOException e) {
            System.out.println("File " + fileName + " not found!");
            System.exit(-1);
        } catch (NotEnoughDataException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.getStackTrace();
        }
        return catalogueOfDevices;
    }


    private Device createDeviceFromLine(String line) throws NotEnoughDataException {
        String[] deviceCharacteristics = line.trim().split(",");
        emptyFieldValidation(deviceCharacteristics);
        if (deviceCharacteristics[headerMap.get("type")].equals("Telephone")) {
            return createTelephone(deviceCharacteristics);
        }
        return createTelevision(deviceCharacteristics);
    }

    private Device createTelevision(String[] deviceCharacteristics) {
        return new Television(deviceCharacteristics[headerMap.get("series")],
                deviceCharacteristics[headerMap.get("screen type")],
                Integer.parseInt(deviceCharacteristics[headerMap.get("price")]),
                Integer.parseInt(deviceCharacteristics[headerMap.get("diagonal")]),
                deviceCharacteristics[headerMap.get("country")]);
    }

    private Device createTelephone(String[] deviceCharacteristics) {
        return new Telephone(deviceCharacteristics[headerMap.get("series")],
                deviceCharacteristics[headerMap.get("screen type")],
                Integer.parseInt(deviceCharacteristics[headerMap.get("price")]),
                deviceCharacteristics[headerMap.get("model")]);
    }

    private void readHeader(String line) throws NotEnoughDataException {
        String[] header = line.trim().split(",");
        headerValidation(header);
        for (int i = 0; i < header.length; i++) {
            headerMap.put(header[i].toLowerCase(), i);
        }
    }

    private void headerValidation(String[] header) throws NotEnoughDataException {
        for (String characteristicName : header) {
            if (characteristicName.matches(".*\\d.*")) {
                throw new NotEnoughDataException("Header is not valid!");
            }
        }
    }

    private void emptyFieldValidation(String[] characteristics) throws NotEnoughDataException {
        for (String characteristic : characteristics) {
            if (characteristic.isEmpty()) {
                throw new NotEnoughDataException("Not enough data in field!");
            }
        }
    }

    private BufferedReader createFileBufferReader(String fileName) throws FileNotFoundException {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            InputStream obj = Objects.requireNonNull(loader.getResourceAsStream(fileName));
            return new BufferedReader(new InputStreamReader(obj));
        } catch (NullPointerException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    public void writeLog(List<Invoice> invoices) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("invoiceLogging.txt"))) {
            for (Invoice invoice : invoices) {
                bufferedWriter.write(invoice + "\n");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
