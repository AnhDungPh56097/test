package bailam.bai2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SanPhamServiceTest {
    private SanPhamService sanPhamService;

    @BeforeEach
    void setUp() {
        sanPhamService = new SanPhamService();
        sanPhamService.themSanPham(new SanPham("SP001", "Điện thoại", 2, 15000000, 5, "Công nghệ"));

    }

    @Test
    void testXoaSanPham_ThanhCong() {
        boolean ketQua = sanPhamService.xoaSanPham("SP001");
        assertTrue(ketQua, "Xóa sản phẩm thành công nhưng kết quả trả về sai");
        assertEquals(0, sanPhamService.soLuongSanPham(), "Số lượng sản phẩm không giảm sau khi xóa");
    }

    private void assertTrue(boolean ketQua, String s) {
    }

    @Test
    void testXoaSanPham_KhongTonTai() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sanPhamService.xoaSanPham("SP999");
        });
        assertEquals("Sản phẩm không tồn tại!", exception.getMessage());
    }

    @Test
    void testXoaSanPham_EmptyList() {
        sanPhamService.xoaSanPham("SP001");  // Xóa sản phẩm duy nhất
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sanPhamService.xoaSanPham("SP001");
        });
        assertEquals("Sản phẩm không tồn tại!", exception.getMessage());
    }
}
