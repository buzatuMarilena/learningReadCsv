package readCsvFile;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadCsvFile {

    public static void main(String args[]){

        String line = "";
        String splitBy = ",";
        List<SkiAthletModel> athletsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/marilena.buzatu/UDEMY/exercitiiDaniel/readCsv/file.csv"))){

            while((line = br.readLine()) != null){

                //citire
                String[] athletDetailsCsv = line.split(splitBy);
                SkiAthletModel athlet = createAthlete(athletDetailsCsv);

                //concatenarea celor 3 rezultate intr.un string
                //verificare de cate or apare o in acest string
                String shootingRangeCsv = athlet.getFirstShootingRange()+athlet.getSecondShootingRange()+athlet.getThirShootingRange();
                int countPenalities = 0;
                for(int i=0;i< shootingRangeCsv.length();i++){
                    if(shootingRangeCsv.charAt(i) == 'o')
                        countPenalities ++;
                }
                countPenalities = countPenalities*10;

                int penalitiesMinutesSeconds[] = getSkiTime(countPenalities);

                LocalTime  finalResult = LocalTime.parse("00:" + athlet.getSkiTimeResult());

                finalResult = finalResult.plusMinutes(penalitiesMinutesSeconds[0]);
                finalResult = finalResult.plusSeconds(penalitiesMinutesSeconds[1]);

                athlet.setFinalResult(finalResult);
                athlet.setPenalities(countPenalities);

                athletsList.add(athlet);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        athletsList.sort(Comparator.comparing(SkiAthletModel::getFinalResult));
//        int i = 0;
//        for(SkiAthletModel temp:athletsList){
//            if(i ==0) {
//                System.out.println("Winner - " + temp.getAthleteName() + "  " + temp.getFinalResult() + " ("+temp.getSkiTimeResult() +" + " + temp.getPenalities() + ")");
//                i++;
//            }
//            else
//                if(i==1){
//                    System.out.println("Runner-up - " + temp.getAthleteName() + "  " + temp.getFinalResult()+ " ("+temp.getSkiTimeResult() +" + " + temp.getPenalities() + ")");
//                    i++;
//                }
//                else
//                    if(i==2){
//                        System.out.println("Third Place - " + temp.getAthleteName() + "  " + temp.getFinalResult()+ " ("+temp.getSkiTimeResult() +" + " + temp.getPenalities() + ")");
//                        i++;
//                    }
//        }

        System.out.println("Winner - " + athletsList.get(0).getAthleteName() + "  " +
                athletsList.get(0).getFinalResult() + " ("+athletsList.get(0).getSkiTimeResult() +" + " + athletsList.get(0).getPenalities() + ")");
        System.out.println("Runner-up - " + athletsList.get(1).getAthleteName() + "  " +
                athletsList.get(1).getFinalResult() + " ("+athletsList.get(1).getSkiTimeResult() +" + " + athletsList.get(1).getPenalities() + ")");
        System.out.println("Third Place - " + athletsList.get(2).getAthleteName() + "  " +
                athletsList.get(2).getFinalResult() + " ("+athletsList.get(2).getSkiTimeResult() +" + " + athletsList.get(2).getPenalities() + ")");

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Winner - " + athletsList.get(0).getAthleteName() + "  " +
                athletsList.get(0).getFinalResult() + " ("+athletsList.get(0).getSkiTimeResult() +" + " + athletsList.get(0).getPenalities() + ")" );

        panel.add(label);
        frame.add(panel);
        frame.setLocationRelativeTo(null);

        frame.setSize(300, 200);
        frame.setVisible(true);


    }

    private static SkiAthletModel createAthlete(String[] metadata){
        Long athleteNumber = Long.parseLong(metadata[0]);
        String athleteName = metadata[1];
        String countryCode = metadata[2];
        String skiTimeResult = metadata[3];
        String firstShootingRange = metadata[4];
        String secondShootingRange = metadata[5];
        String thirdShootingRange = metadata[6];

        return new SkiAthletModel(athleteNumber, athleteName, countryCode, skiTimeResult, firstShootingRange,
                secondShootingRange, thirdShootingRange);
    }

    public static int[] getSkiTime(int penalitiesCount){
        int minutes = 0;
        int seconds = 0;

        if(penalitiesCount > 60){
            minutes = penalitiesCount/60;
            seconds = penalitiesCount - minutes*60;
        }else
            seconds = penalitiesCount;

        return new int[]{ minutes, seconds};
    }


}
