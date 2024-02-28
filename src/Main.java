import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<String> namesList = new ArrayList<>();
//        namesList.add("Aastha");
//        namesList.add("Deepanshu");
//        namesList.add("Javed");
//        namesList.add("Ajit");
//        Map<String, Integer> sortedMap =
//                namesList.stream()
//                        .collect(Collectors.toMap(
//                                key -> key,
//                                String::length));
//
//        System.out.print(sortedMap);
//        int[] nums = {2,3,4,7,2,11,15};
//        int target = 9;
//        System.out.print(Arrays.toString(missingNumberNearest(nums, target)));

        int[] nums = {0,1,2,4,5,7};
        System.out.print(summaryRanges(nums));
    }

    private static int[] findMissingElment(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int shortestDistance = Integer.MAX_VALUE;
        int[] nearestIndexes = new int[2];

        for (int i=0; i<arr.length; i++) {
            int missingNumber = target - arr[i];

            if (map.containsKey(missingNumber)) {
                int missingIndex = map.get(missingNumber);
                int curretnDistance = Math.abs(missingIndex-i);

                if (curretnDistance < shortestDistance) {
                    shortestDistance = curretnDistance;
                    nearestIndexes[0] = missingIndex;
                    nearestIndexes[1] = i;
                }
            }
            map.put(arr[i], i);
        }
        return nearestIndexes;
    }

    private static int[] missingNumber(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int missingNumber = target-arr[i];
            if (map.containsKey(missingNumber)) {
                return new int[]{map.get(missingNumber), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    private static int[] missingNumberNearest(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int shortestDistance = Integer.MAX_VALUE;
        int[] nearestIndexes = new int[2];

        for (int i=0; i<arr.length; i++) {
            int missingNumber = target - arr[i];
            if (map.containsKey(missingNumber)) {
                int missingIndex = map.get(missingNumber);
                int currentDistance = Math.abs(missingIndex - i);
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                    nearestIndexes[0] = missingIndex;
                    nearestIndexes[1] = i;
                }
            }
            map.put(arr[i], i);
        }
        return nearestIndexes;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> resp = new ArrayList<String>();
        for (int i=0; i<nums.length; i++) {
            int start = nums[i];
            while (i+1 < nums.length && nums[i+1] == nums[i]+1) {
                i++;
            }
            if (start != nums[i]) {
                resp.add("" + start + "->" + nums[i]);
            } else {
                resp.add("" + start);
            }
        }
        return resp;
    }
}