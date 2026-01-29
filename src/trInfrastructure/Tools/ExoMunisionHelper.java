package trInfrastructure.Tools;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

/**
 * Lee storage/DataFiles/ExoMunision.txt. Formato: TipoExobot,TipoArma,AccionArma,municionEnergia
 * Caso 7,8: ExoMedico -> BioSensor/BioEscaner, asistir, Energía
 */
public abstract class ExoMunisionHelper {
    private static final String DF = "src/storage/DataFiles/ExoMunision.txt";

    private ExoMunisionHelper() {}

    /** @return [TipoArma, AccionArma, municipionEnergia] o null si no se encuentra */
    public static String[] trGetForTipoExobot(String tipoExobot) {
        try {
            File f = new File(DF);
            if (!f.exists()) return null;
            List<String> lineas = Files.readAllLines(f.toPath());
            for (String L : lineas) {
                String s = L.trim();
                if (s.isEmpty() || s.startsWith("#")) continue;
                String[] parts = s.split(",");
                if (parts.length >= 4 && parts[0].trim().equalsIgnoreCase(tipoExobot))
                    return new String[]{ parts[1].trim(), parts[2].trim(), parts[3].trim() };
            }
        } catch (Exception e) {
            System.err.println("ExoMunisionHelper: " + e.getMessage());
        }
        return null;
    }

    /** Mapeo fijo TipoExobot -> [TipoArma, AccionArma] por si falla el archivo. Caso 7,8: ExoMedico. */
    public static String[] trGetTipoArmaAccion(String tipoExobot) {
        if ("ExoMedico".equalsIgnoreCase(tipoExobot)) return new String[]{"BioSensor/BioEscaner", "asistir"};
        if ("ExoAsalto".equalsIgnoreCase(tipoExobot)) return new String[]{"Fusil/Revolver", "disparar"};
        if ("ExoExplorador".equalsIgnoreCase(tipoExobot)) return new String[]{"GPS/Giroscopio", "detectar"};
        if ("ExoInfanteria".equalsIgnoreCase(tipoExobot)) return new String[]{"Misil/Mortero", "disparar"};
        if ("ExoComando".equalsIgnoreCase(tipoExobot)) return new String[]{"Laser/Bayoneta", "disparar"};
        return new String[]{"?", "?"};
    }
}
