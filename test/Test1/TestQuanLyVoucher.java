
package Test1;

import com.poly.form.voucher.entity.Voucher;
import com.poly.form.voucher.service.VoucherService;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class TestQuanLyVoucher {
    
    VoucherService service = new VoucherService();
    
    @Test
    public void addVoucherValid() throws Exception {
        Voucher voucher = new Voucher("V01", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023), 100, "Con HSD");
        service.them(voucher, "Giam theo gia tien", "Con HSD");
        Assert.assertEquals(10, service.getAll().size());
    }
    
    @Test
    public void addVoucherInValid() throws Exception {
        Voucher voucher = new Voucher("V02", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023), 100, "Con HSD");
        service.them(voucher, "Giam theo gia tien", "Con HSD");
        Assert.assertEquals(1, service.getAll().size());
    }
    
    @Test
    public void updateVoucherValid() throws Exception {
        Voucher voucher = new Voucher(11, "V01", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023),"30/3/2023" ,"30/3/2023" , 100, "Con HSD");
        service.them(voucher, "Giam theo gia tien", "Con HSD");
        
        Voucher voucherNew = new Voucher(11, "V02", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023),"30/3/2023" ,"30/3/2023" , 100, "Con HSD");
        service.capNhat(voucherNew, "Giam theo gia tien", "Con HSD" , 11);

        Assert.assertEquals(11, voucher.getId());
    }
    
    @Test
    public void updateVoucherInValid() throws Exception {
        Voucher voucher = new Voucher("V01", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023), 100, "Con HSD");
        service.them(voucher, "Giam theo gia tien", "Con HSD");
        
        Voucher voucherNew = new Voucher("V02", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023), 100, "Con HSD");
        service.capNhat(voucherNew, "Giam theo gia tien", "Con HSD" , 11);

        Assert.assertEquals("V02", voucher.getMa());
    }
    
    @Test
    public void deleteVoucherValid() throws Exception {
        Voucher voucher = new Voucher("V01", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023), 100, "Con HSD");
        service.them(voucher, "Giam theo gia tien", "Con HSD");
        service.xoa(11);
        Assert.assertEquals(10, service.getAll().size());
    }
    
    @Test
    public void deleteVoucherInValid() throws Exception {
        Voucher voucher = new Voucher("V01", "Giam gia 50% san pham ngay 1/4", 500000, "Giam theo gia tien", 10, new Date(30/3/2023), new Date(4/4/2023), 100, "Con HSD");
        service.them(voucher, "Giam theo gia tien", "Con HSD");
        service.xoa(1);
        Assert.assertEquals(10, service.getAll().size());
    }
}
