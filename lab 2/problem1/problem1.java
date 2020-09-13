package problem1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

class LISTARTIST {

  public static void main(final String[] args) {
    Scanner sc;
    PrintStream ps;
    try {
      final HashMap<String, ArrayList<String>> storage = new HashMap<String, ArrayList<String>>(); // store the artist
                                                                                                   // as the key and his

      sc = new Scanner(new File("input.csv"));
      ps = new PrintStream("output.txt");
      ps.println("\n                       Track Name                                 Total Number Of Streams  \n");
      while (sc.hasNextLine()) {

        final String[] info = Filter(sc.nextLine()); // info[0] contains the streams name and info[1] contains the
                                                     // artist name

        if (storage.containsKey(info[1])) {
          storage.get(info[1]).add(info[0]); // add a son of an existant artist
        } else {
          final ArrayList<String> ListOfSons = new ArrayList<String>(); // the list of the artist's sons
          ListOfSons.add(info[0]);
          storage.put(info[1], ListOfSons);
        }
      }

      // sorting of HashMap by keys by creating a TreeMap with mappings of HashMap
      // TreeMap keeps all entries in sorted order
      final TreeMap<String, ArrayList<String>> sort = new TreeMap<>(storage);
      final Set<Entry<String, ArrayList<String>>> mappings = sort.entrySet();
      for (final Entry<String, ArrayList<String>> mapping : mappings) {
        ps.printf(" %30s  %50d \n", mapping.getKey(), sumValue(mapping.getValue()));
      }

      sc.close(); // closing of the Scanner class
      ps.close(); // closing of the PrintStream class
    } catch (final FileNotFoundException e) {

      e.printStackTrace();
    }
  }

  /*
   * the function below helps filter the informations get from the input file and
   * return an array of string that contain the needed informations(artist name
   * and the stream of each of his songs
   */
  public static String[] Filter(final String line) {
    final String[] result = new String[2];

    final ArrayList<Integer> IndiceOfComma = new ArrayList<Integer>();
    int countQuote = 0; // to count the number of quote that we ancounter in order to get the position
                        // of the right commas(which seperate the colunms).
    for (int i = 0; i < line.length(); i++) {

      if (line.charAt(i) == '\"') {
        if (countQuote == 0)
          countQuote++;
        else
          countQuote = 0;
      }
      if (line.charAt(i) == ',') {
        if (countQuote == 0)
          IndiceOfComma.add(i);
      }
    }

    String Stream = line.substring(IndiceOfComma.get(2), IndiceOfComma.get(3));
    Stream = Stream.substring(1, Stream.length());
    String artistName = line.substring(IndiceOfComma.get(1), IndiceOfComma.get(2));
    if (artistName.contains("\"")) {
      artistName = artistName.substring(2, artistName.length() - 1);
    } else {
      artistName = artistName.substring(1, artistName.length());
    }

    result[0] = Stream;
    result[1] = artistName;

    return result;
  }

  // calculate the total number of streams that an artist have for all his songs
  public static Integer sumValue(final ArrayList<String> list) {
    Integer count = 0;
    for(int i=0; i < list.size(); i++){
       count += Integer.parseInt(list.get(i));
    }
     
    return count;
  }

}