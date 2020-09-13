package SupermarketCashRegister;

/**
 * @Author: JinHe
 * @date: 2020/8/24
 **/
import com.bean.Goods;
import com.bean.GoodsPrivoder;
import com.bean.Instore;
import com.dao.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ShangPinJPanel extends JPanel  implements ActionListener , MouseListener {
    private JPanel jp_chaxun;
    private JLabel jl_shangpinchaxun;
    private JTextField jf_shangpinchaxun;
    private JButton jb_chaxun;
    private JScrollPane jsp_shangpin;
    private JTable jt_shangpin;
    private JPanel jp_weihu;
    private JLabel jl_tiaoxingma;
    private JTextField jf_tiaoxingma;
    private JLabel jl_pinming;
    private JTextField jf_pinming;
    private JLabel jl_leibie;
    private JComboBox jcb_leibie;
    private JLabel jl_danwei;
    private JComboBox jcb_danwei;
    private JLabel jl_guige;
    private JTextField jf_guige;
    private JLabel jl_jinjia;
    private JTextField jf_jinjia;
    private JTextField jf_shoujia;
    private JTextField jf_huiyuanjia;
    private JComboBox jcb_gonghuoshang;
    private JTextField jf_jinhuoliang;
    private JTextField jf_kucunliang;
    private JTextField jf_liushuihao;
    private JTextField jf_baojingshu;
    private JButton jb_tinajia;
    private JButton jb_xiugai;
    private JButton jb_shanchu;
    private JButton jb_qingkong;
    private  DefaultTableModel model;

    private DaoGoods daogs = new DaoGoods();
    private DaoGoodsClass daogc = new DaoGoodsClass();
    private DaoGoodsUtil daogdu = new DaoGoodsUtil();
    private DaoGoodsPrivoder daogpd = new DaoGoodsPrivoder();
    private DaoInstore daois = new DaoInstore();

    private ArrayList<Goods> list;

    public ShangPinJPanel(){
        initGUI();
    }

    private void initGUI() {
        // TODO Auto-generated method stub
        this.setPreferredSize(new Dimension(730,550));
        BorderLayout layout=new BorderLayout();
        this.setLayout(layout);
        {
            jp_chaxun=new JPanel();
            jp_chaxun.setPreferredSize(new Dimension(725,230));
            jp_chaxun.setLayout(null);
            jp_chaxun.setBorder(BorderFactory.createTitledBorder("商品查询"));

            this.add(jp_chaxun,BorderLayout.NORTH);
            jl_shangpinchaxun=new JLabel();
            jl_shangpinchaxun.setText("商品查询(条形码/名称/类别):");
            jl_shangpinchaxun.setBounds(24, 25, 176, 20);
            jp_chaxun.add(jl_shangpinchaxun);
            //放置关键字文本框
            jf_shangpinchaxun = new JTextField();
            jf_shangpinchaxun.setBounds(210,25, 250, 25);
            jp_chaxun.add(jf_shangpinchaxun);

            //查询按钮
            jb_chaxun = new JButton();
            jb_chaxun.setText("查询");
            jb_chaxun.addActionListener(this);
            jb_chaxun.setBounds(510,25, 60, 25);
            jp_chaxun.add(jb_chaxun);
            {
                jsp_shangpin=new JScrollPane();
                jsp_shangpin.setBounds(5, 55, 700, 170);
                jp_chaxun.add(jsp_shangpin);

                model=new DefaultTableModel(null,new String[] {"商品条形码", "品名", "类别", "规格", "单位",
                        "报警数量", "零售价", "会员价", "库存量"});
                jt_shangpin=new JTable(model);
                jsp_shangpin.setViewportView(jt_shangpin);
                jt_shangpin.addMouseListener(this);

                list = daogs.selectAll();
                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "未连接用户数据库");
                } else {
//			遍历集合
                    for (int i = 0; i < list.size(); i++) {
                        Goods gs = list.get(i);
//				将需要的数据组成数组，放到addRow方法中
                        String[] rowData = {
                                gs.getgId(), gs.getgName(), String.valueOf(gs.getCid()),gs.getgSpec(), String.valueOf(gs.getgUId()),
                                String.valueOf(gs.getgMinNUmber()), String.valueOf(gs.getSalePrice()), String.valueOf(gs.getVipPrice()),
                                String.valueOf(gs.getgAmount())
                        };
                        model.addRow(rowData);
                    }
                }

            }
        }
        {
            jp_weihu=new JPanel();
            jp_weihu.setPreferredSize(new Dimension(725,150));
            jp_weihu.setLayout(null);
            jp_weihu.setBorder(BorderFactory.createTitledBorder("商品维护"));
            this.add(jp_weihu,BorderLayout.CENTER);
            //条形码
            jl_tiaoxingma=new JLabel();
            jl_tiaoxingma.setText("条形码:");
            jl_tiaoxingma.setBounds(25, 25, 50, 25);
            jp_weihu.add(jl_tiaoxingma);
            jf_tiaoxingma = new JTextField();
            jf_tiaoxingma.setBounds(75,25, 170, 25);
            jp_weihu.add(jf_tiaoxingma);
            //品名
            jl_pinming=new JLabel();
            jl_pinming.setText("品名:");
            jl_pinming.setBounds(285, 25, 50, 25);
            jp_weihu.add(jl_pinming);
            jf_pinming = new JTextField();
            jf_pinming.setBounds(350,25,250, 25);
            jp_weihu.add(jf_pinming);
            //类别
            jl_leibie=new JLabel();
            jl_leibie.setText("类别:");
            jl_leibie.setBounds(25,60, 50, 25);
            jp_weihu.add(jl_leibie);
            jcb_leibie=new JComboBox(daogc.selectCname().toArray());
            jcb_leibie.setBounds(75, 60, 125, 25);
            jp_weihu.add(jcb_leibie);
            //单位
            jl_danwei=new JLabel();
            jl_danwei.setText("单位:");
            jl_danwei.setBounds(285,60, 50, 25);
            jp_weihu.add(jl_danwei);
            jcb_danwei=new JComboBox(daogdu.selectGUname().toArray());
            jcb_danwei.setBounds(330, 60, 100, 25);
            jp_weihu.add(jcb_danwei);
            //规格
            jl_guige=new JLabel();
            jl_guige.setText("规格:");
            jl_guige.setBounds(455, 60, 50, 25);
            jp_weihu.add(jl_guige);
            jf_guige = new JTextField();
            jf_guige.setBounds(500,60,100, 25);
            jp_weihu.add(jf_guige);
            //进价
            jl_jinjia=new JLabel();
            jl_jinjia.setText("进价:");
            jl_jinjia.setBounds(25,100, 50, 25);
            jp_weihu.add(jl_jinjia);
            jf_jinjia = new JTextField();
            jf_jinjia.setBounds(75, 100, 125, 25);
            jp_weihu.add(jf_jinjia);
            //售价
            JLabel jl_shoujia=new JLabel();
            jl_shoujia.setText("售价:");
            jl_shoujia.setBounds(285,100, 50, 25);
            jp_weihu.add(jl_shoujia);
            jf_shoujia = new JTextField();
            jf_shoujia.setBounds(330,100, 100, 25);
            jp_weihu.add(jf_shoujia);
            //会员价
            JLabel jl_huiyuanjia=new JLabel();
            jl_huiyuanjia.setText("会员价:");
            jl_huiyuanjia.setBounds(445,100, 50, 25);
            jp_weihu.add(jl_huiyuanjia);
            jf_huiyuanjia = new JTextField();
            jf_huiyuanjia.setBounds(500,100,100, 25);
            jp_weihu.add(jf_huiyuanjia);
            //供货商
            JLabel jl_gonghuosahng=new JLabel();
            jl_gonghuosahng.setText("供货商:");
            jl_gonghuosahng.setBounds(25,135, 50, 25);
            jp_weihu.add(jl_gonghuosahng);
            jcb_gonghuoshang=new JComboBox(daogpd.selectCname().toArray());
            jcb_gonghuoshang.setBounds(75, 135, 170, 25);
            jp_weihu.add(jcb_gonghuoshang);
            //进货量
            JLabel jl_jinhuoliang=new JLabel();
            jl_jinhuoliang.setText("进货量:");
            jl_jinhuoliang.setBounds(275,135, 50, 25);
            jp_weihu.add(jl_jinhuoliang);
            jf_jinhuoliang = new JTextField();
            jf_jinhuoliang.setBounds(330,135, 100, 25);
            jp_weihu.add(jf_jinhuoliang);
            //库存量
            JLabel jl_kucunliang=new JLabel();
            jl_kucunliang.setText("库存量:");
            jl_kucunliang.setBounds(445,135, 50, 25);
            jp_weihu.add(jl_kucunliang);
            jf_kucunliang = new JTextField();
            jf_kucunliang.setEditable(false);
            jf_kucunliang.setBounds(500,135,100, 25);

            jp_weihu.add(jf_kucunliang);
            //流水号
            JLabel jl_liushuihao=new JLabel();
            jl_liushuihao.setText("流水号:");
            jl_liushuihao.setBounds(25,170, 50, 25);
            jp_weihu.add(jl_liushuihao);
            jf_liushuihao = new JTextField();
            jf_liushuihao.setEditable(false);
            jf_liushuihao.setBounds(75, 170, 170, 25);

            jp_weihu.add(jf_liushuihao);
            //报警数
            JLabel jl_baojingshu=new JLabel();
            jl_baojingshu.setText("报警数:");
            jl_baojingshu.setBounds(275,170, 50, 25);
            jp_weihu.add(jl_baojingshu);
            jf_baojingshu = new JTextField();
            jf_baojingshu.addMouseListener(this);
            jf_baojingshu.setBounds(330,170, 100, 25);
            jp_weihu.add(jf_baojingshu);
            //添加商品按钮
            jb_tinajia = new JButton();
            jb_tinajia.setText("添加商品");
            jb_tinajia.addActionListener(this);
            jb_tinajia.setBounds(100,230,100, 30);
            jp_weihu.add(jb_tinajia);
            //修改商品按钮
            jb_xiugai = new JButton();
            jb_xiugai.setText("修改商品");
            jb_xiugai.addActionListener(this);
            jb_xiugai.setBounds(220,230,100, 30);
            jp_weihu.add(jb_xiugai);
            //删除商品按钮
            jb_shanchu = new JButton();
            jb_shanchu.setText("删除商品");
            jb_shanchu.addActionListener(this);
            jb_shanchu.setBounds(340,230,100, 30);
            jp_weihu.add(jb_shanchu);
            //清空按钮
            jb_qingkong = new JButton();
            jb_qingkong.setText("清空");
            jb_qingkong.addActionListener(this);
            jb_qingkong.setBounds(460,230, 100, 30);
            jp_weihu.add(jb_qingkong);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==jb_chaxun){
            String info = jf_shangpinchaxun.getText();
            if (info.equals("")) {
                list = daogs.selectAll();
                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "未连接用户数据库");
                } else {
                    //遍历集合
                    for (int i = 0; i < list.size(); i++) {
                        Goods gs = list.get(i);
                        //将需要的数据组成数组，放到addRow方法中
                        String[] rowData = {
                                gs.getgId(), gs.getgName(), String.valueOf(gs.getCid()),gs.getgSpec(), String.valueOf(gs.getgUId()),
                                String.valueOf(gs.getgMinNUmber()), String.valueOf(gs.getSalePrice()), String.valueOf(gs.getVipPrice()),
                                String.valueOf(gs.getgAmount())
                        };
                        model.addRow(rowData);
                    }
                }
                refreshTable();
            } else {
                //清空表格
                for (int i = model.getRowCount() - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                // 模糊查询
                list = daogs.selectByGidOrGnameOrCid(info);
                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "没有你要查找的信息!");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        Goods gs = list.get(i);
                        //将需要的数据组成数组，放到addRow方法中
                        String[] rowData = {
                                gs.getgId(), gs.getgName(), String.valueOf(gs.getCid()),gs.getgSpec(), String.valueOf(gs.getgUId()),
                                String.valueOf(gs.getgMinNUmber()), String.valueOf(gs.getSalePrice()), String.valueOf(gs.getVipPrice()),
                                String.valueOf(gs.getgAmount())
                        };
                        model.addRow(rowData);
                    }
                }
            }
        }
        if (source==jb_tinajia){
            // 1.获取数据
            String gid = jf_tiaoxingma.getText();
            String gname = jf_pinming.getText();
            String cname = String.valueOf(jcb_leibie.getSelectedItem());
            String guname = (String) jcb_danwei.getSelectedItem();
            String gspec = jf_guige.getText();
            String purchasePrice = jf_jinjia.getText();
            String SalePrice = jf_shoujia.getText();
            String VipPrice = jf_huiyuanjia.getText();
            String gpname = (String) jcb_gonghuoshang.getSelectedItem();
            String inStoreAmount = jf_jinhuoliang.getText();
            String GAmount = jf_kucunliang.getText();
            String InStoreId = jf_liushuihao.getText();
            String GMinNumber = jf_baojingshu.getText();
            //2.判断数据是否为空
            if (gid.equals("") || gname.equals("") || cname.equals("") || guname.equals("")|| gspec.equals("")|| purchasePrice.equals("")
                    || SalePrice.equals("")||VipPrice.equals("")|| gpname.equals("")|| inStoreAmount.equals("")|| GAmount.equals("")
                    || InStoreId.equals("")|| GMinNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "信息不能为空!");
            } else {
                //3.查看id是否存在
                Goods g = daogs.selectByGId(gid);
                if (g == null) {
                    //4.如果不存在，则进行添加
                    int cid = daogc.selectCid(cname);
                    int guid = daogdu.selectgUid(guname);
                    int gMinNumber = Integer.parseInt(GMinNumber);
                    double salePrive = Double.parseDouble(SalePrice);
                    int nowGAmount = Integer.parseInt(GAmount) + Integer.parseInt(inStoreAmount);


                    boolean b = daogs.InsertGoods(gid,cid,guid,gname,gspec, gMinNumber,salePrive,Double.parseDouble(VipPrice),nowGAmount);
                    Instore is = new Instore(InStoreId, Integer.parseInt(inStoreAmount), Double.parseDouble(purchasePrice));
                    GoodsPrivoder gpd = new GoodsPrivoder(gpname);
                    boolean a = daois.southInsert(is,gpd,gid);
                    if (b && a) {
                        JOptionPane.showMessageDialog(null, "操作成功!");
                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "操作失败!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "此货物已经存在!");
                }
            }

        }
        if (source==jb_xiugai){
            // 1.获取数据
            String gid = jf_tiaoxingma.getText();
            String gname = jf_pinming.getText();
            String cname = String.valueOf(jcb_leibie.getSelectedItem());
            String guname = (String) jcb_danwei.getSelectedItem();
            String gspec = jf_guige.getText();
            String purchasePrice = jf_jinjia.getText();
            String SalePrice = jf_shoujia.getText();
            String VipPrice = jf_huiyuanjia.getText();
            String gpname = (String) jcb_gonghuoshang.getSelectedItem();
            String inStoreAmount = jf_jinhuoliang.getText();
            String GAmount = jf_kucunliang.getText();
            String InStoreId = jf_liushuihao.getText();
            String GMinNumber = jf_baojingshu.getText();
            //2.判断数据是否为空
            if ( gname.equals("") || cname.equals("") || guname.equals("")|| gspec.equals("")|| purchasePrice.equals("")
                    || SalePrice.equals("")||VipPrice.equals("")|| gpname.equals("")|| inStoreAmount.equals("")
                    ||  GMinNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "信息不能为空!");
            } else {
                //修改商品表
                int  NowGAmount = Integer.parseInt(GAmount )+  Integer.parseInt(inStoreAmount);
                boolean a = daogs.updateBygid(gid,Double.parseDouble(SalePrice),Double.parseDouble(VipPrice), Integer.parseInt(GMinNumber),NowGAmount);
                //修改instore表
                boolean b = daois.updateByinstoreid(InStoreId,Double.parseDouble(purchasePrice),daogpd.selectByGpname(gpname), Integer.parseInt(inStoreAmount));

                if (a&&b) {
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "修改成功!");
                } else {
                    JOptionPane.showMessageDialog(null, "修改失败!");
                }
            }
        }
        if (source==jb_shanchu){
            //获取数据
            String gid = jf_tiaoxingma.getText();
            String InStoreId = jf_liushuihao.getText();
            //直接删除，不留后患！！！！犹豫就会失败，冲冲冲！
            JOptionPane.showMessageDialog(null,"是否删除？（虽然我没用，但是后续会加入！）");
            //删除商品表记录
            int a =  daogs.deleteByGId(gid);
            //删除进货记录表的记录
            int b = daois.deleteByInstoreId(InStoreId);
            if(a>0&&b>0){
                JOptionPane.showMessageDialog(null,"删除成功！");
                refreshTable();
            }else{
                JOptionPane.showMessageDialog(null,"删除失败！");
            }

        }
        if(source==jb_qingkong){
            //设置文本框为空白，下拉框不改了
            jf_tiaoxingma.setEditable(true);
            jf_pinming.setEditable(true);
            jf_guige.setEditable(true);
            jf_tiaoxingma.setText("");
            jf_pinming.setText("");
            jcb_leibie.setSelectedItem("");
            jf_guige.setText("");
            jcb_danwei.setSelectedItem("");
            jf_baojingshu.setText("");
            jf_shoujia.setText("");
            jf_huiyuanjia.setText("");
            jf_kucunliang.setText("");
            jf_jinhuoliang.setEditable(true);

        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source==jf_baojingshu) {
            //1.获取数据
            String gId = jf_tiaoxingma.getText();
            String gName = jf_pinming.getText();
            //2.调用显示库存的方法
            String n = String.valueOf(daogs.inStock(gId, gName));
            jf_kucunliang.setText(n);
            //3.生成流水号的方法
            jf_liushuihao.setText(getTime());
        }
        if(source==jt_shangpin){
            // 1.获取表格中的数据
            // 获取表格中被选中的行号
            int row = jt_shangpin.getSelectedRow();
            String gid = jt_shangpin.getValueAt(row, 0).toString();
            String gname = jt_shangpin.getValueAt(row, 1).toString();
            String cid = jt_shangpin.getValueAt(row, 2).toString();
            String gspec = jt_shangpin.getValueAt(row, 3).toString();
            String guid = jt_shangpin.getValueAt(row,4).toString();
            String GMinNumber = jt_shangpin.getValueAt(row, 5).toString();
            String SalePrice = jt_shangpin.getValueAt(row, 6).toString();
            String VipPrice = jt_shangpin.getValueAt(row, 7).toString();
            String GAmount = jt_shangpin.getValueAt(row, 8).toString();


            // 通过gid从instore表查询进价,进货量，流水号，（供货商编号，用编号拿到名称）》》》》直接查询instore对象 进货时间
            // 通过编号拿名称
            // 将拿到的数据放到文本框中
            Instore is = daois.selectByGid(gid);
            int inStoreAmount = is.getInStoreAmount();
            String InStoreId = is.getInStoreId();
            double purchasePrice = is.getPurchasePrice();
            int gpid = is.getgPId();

            jf_tiaoxingma.setEditable(false);
            jf_tiaoxingma.setText(gid);
            jf_pinming.setText(gname);
            jf_pinming.setEditable(false);
            jcb_leibie.setSelectedItem(daogc.selectCname(cid));
            jf_guige.setText(gspec);
            jf_guige.setEditable(false);
            jcb_danwei.setSelectedItem(daogdu.selectgUname(guid));
            jf_baojingshu.setText(GMinNumber);
            jf_shoujia.setText(SalePrice);
            jf_huiyuanjia.setText(VipPrice);
            jf_kucunliang.setText(GAmount);
            jf_jinhuoliang.setText(String.valueOf(inStoreAmount));
            jf_jinjia.setText(String.valueOf(purchasePrice));
            jf_liushuihao.setText(InStoreId);
            jcb_gonghuoshang.setSelectedItem(daogpd.selectByGpid(String.valueOf(gpid)));


        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void refreshTable() {
        //清空表格
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        // 全部查询
        list = daogs.selectAll();
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(null, "没有你要查找的信息!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Goods  gs= list.get(i);
                //将需要的数据组成数组，放到addRow方法中
                String[] rowData = {
                        gs.getgId(), gs.getgName(), String.valueOf(gs.getCid()),gs.getgSpec(), String.valueOf(gs.getgUId()),
                        String.valueOf(gs.getgMinNUmber()), String.valueOf(gs.getSalePrice()), String.valueOf(gs.getVipPrice()),
                        String.valueOf(gs.getgAmount())
                };
                model.addRow(rowData);
            }

        }
    }
    //生成流水号的方法
    public String getTime(){
        String t = null;
        Calendar c = Calendar.getInstance();
        //获取年份
        int year = c.get(Calendar.YEAR);
        String year1 = year+"";
        //获取月份
        int month = c.get(Calendar.MONTH)+1;
        String month1 = month+"";
        //获取日期
        int date = c.get(Calendar.DATE);
        String date1 = date+"";
        //获取小时
        int hour = c.get(Calendar.HOUR);
        String hour1 = hour+"";
        //获取分钟
        int minute = c.get(Calendar.MINUTE);
        String minute1 = minute+"";
        //连接起来
        t=year1+month1+date1+hour1+minute1;
        return t;
    }
}

