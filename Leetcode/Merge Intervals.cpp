/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
    
private:

    static bool sortFunc(Interval& a, Interval& b) { return a.start<b.start; }
    
public:
    vector<Interval> merge(vector<Interval> &intervals) {
        
        vector<Interval> res;
        
        if(intervals.size()==0) return res;
        
        std::sort(intervals.begin(),intervals.end(),sortFunc);
        
        Interval temp = intervals[0];
        for(int i=1;i<intervals.size(); ++i)
        {
            if(temp.end>=intervals[i].start) 
            {
                temp.end=(temp.end>intervals[i].end)?temp.end:intervals[i].end;
            }
            else
            {
                res.push_back(temp);
                temp=intervals[i];
            }
        }
        
        res.push_back(temp);
        
        return res;
    }
};
