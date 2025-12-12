package mixpractice;

import java.util.*;

class countmentionsperuser {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, new Comparator<List<String>>(){
            @Override
            public int compare(List<String> a, List<String> b) {
                int timeA = Integer.parseInt(a.get(1));
                int timeB = Integer.parseInt(b.get(1));
                if (timeA != timeB)
                    return Integer.compare(timeA, timeB);
                else {
                    String typeA = a.get(0);
                    String typeB = b.get(0);
                    if (typeA.equals(typeB))
                        return 0;
                    if (typeA.equals("OFFLINE"))
                        return -1;
                    if (typeB.equals("OFFLINE"))
                        return 1;
                    return 0;
                }
            }
        });
        int[] mentions = new int[numberOfUsers];
        int[] online_time = new int[numberOfUsers];
        Arrays.fill(online_time,-1);
        int all=0;
        for(int i=0;i<events.size();i++) {
            List<String> event = events.get(i);
            if(event.get(0).equals("MESSAGE")) {
                int timestamp = Integer.valueOf(event.get(1));
                String mentions_string = event.get(2);
                if(mentions_string.equals("ALL"))
                    all++;
                else if(mentions_string.equals("HERE")) {
                    for(int j=0;j<numberOfUsers;j++) {
                        if(online_time[j]<= timestamp)
                            mentions[j]++;
                    }
                } else {
                    String[] ids = mentions_string.split(" ");
                    for(String id : ids) {
                        int ID = Integer.valueOf(id.substring(2));
                        mentions[ID]++;
                    }
                }

            } else {
                int timestamp = Integer.valueOf(event.get(1));
                int id = Integer.valueOf(event.get(2));
                online_time[id] = timestamp + 60;
            }
        }
        for(int i=0;i<numberOfUsers;i++)
            mentions[i]+=all;
        return mentions;
    }
    public static void main(String[] args) {
        countmentionsperuser sol = new countmentionsperuser();
        List<List<String>> events = new ArrayList<>();
        events.add(Arrays.asList("ONLINE", "0", "0"));
        events.add(Arrays.asList("MESSAGE", "10", "HERE"));
        events.add(Arrays.asList("ONLINE", "20", "1"));
        events.add(Arrays.asList("MESSAGE", "30", "ALL"));
        events.add(Arrays.asList("OFFLINE", "70", "0"));
        int[] result = sol.countMentions(2, events);
        System.out.println(Arrays.toString(result)); // Expected output: [2, 1]
    }
}