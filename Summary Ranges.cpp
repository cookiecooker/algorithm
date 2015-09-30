class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> res;
        if (nums.empty()) return res;
        string s;
        int start = nums[0], end = nums[0];
        for (int i = 1;i <= nums.size();++i) {
			if (i < nums.size() && nums[i] == end + 1) {
				end = nums[i];
			} else {
				if (start == end) s = to_string(start);
				else s = to_string(start) + "->" + to_string(end);
				res.push_back(s);
				if (i < nums.size()) start = end = nums[i];
		    }
		}
		return res;
    }
};
