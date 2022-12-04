import com.adrynov.LeetCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeTests {

    @Test
    public void findPivotIndex() {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int expected1 = 3;

        int[] nums2 = {1, 2, 3};
        int expected2 = -1;

        int[] nums3 = {2, 1, -1};
        int expected3 = 0;

        assertEquals(expected1, LeetCode.findPivotIndex(nums1));
        assertEquals(expected2, LeetCode.findPivotIndex(nums2));
        assertEquals(expected3, LeetCode.findPivotIndex(nums3));
    }

    @Test
    public void isIsomorphic() {
        assertTrue(LeetCode.isIsomorphic("egg", "add"));
        assertFalse(LeetCode.isIsomorphic("foo", "bar"));
        assertTrue(LeetCode.isIsomorphic("paper", "title"));
        assertTrue(LeetCode.isIsomorphic("aab", "xxy"));
        assertFalse(LeetCode.isIsomorphic("aab", "xyz"));
        assertTrue(LeetCode.isIsomorphic("BCVB", "LKOL"));
        assertFalse(LeetCode.isIsomorphic("PINK", "LOOT"));
        assertTrue(LeetCode.isIsomorphic("WXYZABCXYZ", "PQRSTUVQRS"));
        assertFalse(LeetCode.isIsomorphic("YWSUIOD", "QRUSJHS"));
    }
}
