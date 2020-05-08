import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    
    /**
     * Time - O(n log n)
     * Space - O(n)
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (products == null || products.length == 0 || searchWord == null || searchWord.length() == 0) {
            return res;
        }

        Arrays.sort(products);
        List<String> matchedResults = Arrays.asList(products);

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<String>();
            List<String> newList = new ArrayList<String>();

            for (int j = 0; j < matchedResults.size(); j++) {
                String product = matchedResults.get(j);
                if (product.length() > i) {
                    if (product.charAt(i) == searchWord.charAt(i)) {
                        newList.add(product);
                        if (list.size() < 3) {
                            list.add(product);
                        }
                    }
                }
            }
            matchedResults = newList;
            res.add(list);
        }
        return res;
    }
}