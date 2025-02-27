package bailam.bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SanPhamService {
    private List<SanPham> danhSachSanPham = new ArrayList<>();

    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
    }

    public boolean xoaSanPham(String ma) {
        Optional<SanPham> sanPhamOptional = danhSachSanPham.stream()
                .filter(sp -> sp.getMa().equals(ma))
                .findFirst();

        if (sanPhamOptional.isPresent()) {
            danhSachSanPham.remove(sanPhamOptional.get());
            return true;
        } else {
            throw new IllegalArgumentException("Sản phẩm không tồn tại!");
        }
    }

    public int soLuongSanPham() {
        return danhSachSanPham.size();
    }
}
