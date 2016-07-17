import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KthFrequentWord {
	
	public static class WordNode implements Comparable<WordNode>{
		
		public String word;
		public Integer count;
		
		public WordNode(String word, Integer count){
			this.word = word;
			this.count = count;
		}

		@Override
		public int compareTo(WordNode o) {
			return this.count.compareTo(o.count);
		}
	}

	public static void main(String[] args) {

		List<String> result = getKMostFrequentWords("aaa bbb aaa bb ccc bbb cccc aaa bbb ccc bbb", 3);

	}
	
	public static List<String> getKMostFrequentWords(String instream, int k){
		
		HashMap<String, Integer> wordCount = buildWordCountMap(instream);
		List<String> topKWords = getTopKWordsFromMap(wordCount,k);
		
		for(String word : topKWords){
			System.out.println(word);
		}
		return topKWords;
	}

	private static List<String> getTopKWordsFromMap(HashMap<String, Integer> wordCount, int k) {

		
		PriorityQueue<WordNode> minHeap = new PriorityQueue<WordNode>(k);
		
		for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet()) {
			
			WordNode wordNode = new WordNode(wordEntry.getKey(), wordEntry.getValue());
			
			if(minHeap.size() < k){	
				minHeap.add(wordNode);

			}else{
				
				if(minHeap.peek().count<wordEntry.getValue()){
					minHeap.poll();
					minHeap.add(wordNode);
				}
			}
		}
		
		List<String> topKWords = new ArrayList<String>();
		for (WordNode wordNode : minHeap) {
			System.out.println("Adding word : " + wordNode.word);
			topKWords.add(wordNode.word);
		}
		return topKWords;
	}

	private static HashMap<String, Integer> buildWordCountMap(String instream) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
		
		String[] words = instream.split(" ");
		
		for (String word : words) {
			
			Integer currentWordCount = 1;
			
			if(wordcount.containsKey(word)){
				currentWordCount = wordcount.get(word) + 1;
			}
			
			wordcount.put(word, currentWordCount);
		}
		
		return wordcount;
	}

}
