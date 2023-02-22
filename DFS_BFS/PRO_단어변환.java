package DFS_BFS;

class PRO_단어변환 {
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        // 1. words에 타겟 단어가 없는 경우 0 반환
        int i;
        for(i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                break;
            }
        }
        if (i == words.length) {
            return 0;
        }

        // 2. dfs로 begin을 target으로 변환 가능한 모든 경우의 수 탐색
        dfs(begin, 0, words, target);
        System.out.print(answer);

        return answer;
    }

    private void dfs(String word, int sum, String[] words, String target) {
        if (word.equals(target)) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if (check(word, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], sum + 1, words, target);
                visited[i] = false;
            }
        }
    }

    private boolean check(String word, String newWord) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != newWord.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
