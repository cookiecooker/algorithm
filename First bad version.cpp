// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        
        if (n == 1) {
			return 1;
	    }	
	    
	    int left = 1;
	    int right = n;
	    
	    while (left < right) {
			int mid = left + (right - left) / 2;
			if (VersionControl.isBadVersion(mid)) {
		       right = mid;
		    } else {
				left = mid + 1;
		    }		
	    }	
	    
	    return right;
    }
};
