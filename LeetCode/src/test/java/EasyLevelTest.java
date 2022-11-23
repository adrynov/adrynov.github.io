import com.adrynov.leetcode.EaseLeet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EasyLevelTest {

    @Test
    public void findPivotIndex() {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int expected1 = 3;

        int[] nums2 = {1, 2, 3};
        int expected2 = -1;

        int[] nums3 = {2, 1, -1};
        int expected3 = 0;

        assertEquals(expected1, EaseLeet.findPivotIndex(nums1));
        assertEquals(expected2, EaseLeet.findPivotIndex(nums2));
        assertEquals(expected3, EaseLeet.findPivotIndex(nums3));
    }

    @Test
    public void isIsomorphic() {
        assertTrue(EaseLeet.isIsomorphic("egg", "add"));
        assertFalse(EaseLeet.isIsomorphic("foo", "bar"));
        assertTrue(EaseLeet.isIsomorphic("paper", "title"));
        assertTrue(EaseLeet.isIsomorphic("aab", "xxy"));
        assertFalse(EaseLeet.isIsomorphic("aab", "xyz"));
        assertTrue(EaseLeet.isIsomorphic("BCVB", "LKOL"));
        assertFalse(EaseLeet.isIsomorphic("PINK", "LOOT"));
        assertTrue(EaseLeet.isIsomorphic("WXYZABCXYZ", "PQRSTUVQRS"));
        assertFalse(EaseLeet.isIsomorphic("YWSUIOD", "QRUSJHS"));
    }
}
