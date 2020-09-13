package SupermarketCashRegister;

import com.bean.Goods;
import com.bean.GoodsPrivoder;
import com.bean.Instore;
import com.dao.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

/**
 * @Author: JinHe
 * @Date: 2020/6/17
 **/

public class JinHuoJPanel extends Panel implements ActionListener, MouseListener {
    private JPanel jp_jinhuo;
    private JPanel jp_north;
    private JPanel jp_south;
    private JTextField jt_shangpinguanli;
    private JTextField jt_shangpinmingcheng;
    private JTextField jt_dengjiguige;
    private JTextField jt_baojingshuliang;
    private JTextField jt_xiaoshoujiage;
    private JTextField jt_huiyuanjiage;
    private JTextField jt_jinhuoshuliang;
    private JTextField jt_jinhuojiage;

    private JTextField jt_kucunshuliang;
    private JTextField jt_liushuihao;
    private JButton jb_queding;
    private JButton jb_qingkong;
    private JComboBox jc_suoshuleibie;
    private JComboBox jc_jiliangdanwei;
    private JComboBox jc_gonghuoshang;

    private JLabel jl_shangpingaunli;
    private JLabel jl_shangpinmingcheng;
    private JLabel jl_suoshuleibie;
    private JLabel jl_jiliangdanwei;
    private JLabel jl_dengjiguige;
    private JLabel jl_baojingshuliang;
    private JLabel jl_xiaoshoujiage;
    private JLabel jl_huiyuanjiage;
    private JLabel jl_kucunshuliang;
    private JLabel jl_liushuihao;
    private JLabel jl_gonghuoshang;
    private JLabel jl_jinhuoshuliang;
    private JLabel jl_jinhuojiage;

    private DaoGoods daogoods = new DaoGoods();
    private DaoGoodsPrivoder daopd = new DaoGoodsPrivoder();
    private DaoInstore daois = new DaoInstore();
    private DaoGoodsClass daogdc = new DaoGoodsClass();
    private DaoGoodsUtil daogdut = new DaoGoodsUtil();

    // 构造方法
    public JinHuoJPanel() {
        initGUI();
    }

    private void initGUI() {
        // 整体化设置：最佳大小、布局
        this.setPreferredSize(new Dimension(730, 550));
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        // 进货
        {
            jp_jinhuo = new JPanel();
            jp_jinhuo.setPreferredSize(new Dimension(725, 550));
            // 设置边框
            jp_jinhuo.setBorder(BorderFactory.createTitledBorder("进货管理"));
            this.add(jp_jinhuo);

            //上半部分
            {
                jp_north = new JPanel();
                jp_north.setLayout(null);
                jp_north.setPreferredSize(new Dimension(710, 280));
                // 商品管理
                jl_shangpingaunli = new JLabel("商品编号:");
                jl_shangpingaunli.setBounds(10, 10, 60, 25);
                jt_shangpinguanli = new JTextField();
                jt_shangpinguanli.setBounds(80, 10, 240, 25);
                jp_north.add(jl_shangpingaunli);
                jp_north.add(jt_shangpinguanli);
                // 商品名称
                jl_shangpinmingcheng = new JLabel("商品名称:");
                jl_shangpinmingcheng.setBounds(380, 10, 60, 25);
                jt_shangpinmingcheng = new JTextField();
                jt_shangpinmingcheng.setBounds(450, 10, 240, 25);
                jp_north.add(jl_shangpinmingcheng);
                jp_north.add(jt_shangpinmingcheng);
                // 所属类别
                jl_suoshuleibie = new JLabel("所属类别:");
                jl_suoshuleibie.setBounds(10, 70, 60, 25);
                jc_suoshuleibie = new JComboBox(daogdc.selectCname().toArray());
                jc_suoshuleibie.setBounds(80, 70, 240, 25);
                jp_north.add(jl_suoshuleibie);
                jp_north.add(jc_suoshuleibie);
                // 计量单位
                jl_jiliangdanwei = new JLabel("商品单位:");
                jl_jiliangdanwei.setBounds(380, 70, 60, 25);
                jc_jiliangdanwei = new JComboBox(daogdut.selectGUname().toArray());
                jc_jiliangdanwei.setBounds(450, 70, 80, 25);
                jp_north.add(jl_jiliangdanwei);
                jp_north.add(jc_jiliangdanwei);
                // 等级规格
                jl_dengjiguige = new JLabel("等级规格:");
                jl_dengjiguige.setBounds(540, 70, 60, 25);
                jt_dengjiguige = new JTextField();
                jt_dengjiguige.addMouseListener(this);
                jt_dengjiguige.setBounds(609, 70, 80, 25);
                jp_north.add(jl_dengjiguige);
                jp_north.add(jt_dengjiguige);
                // 报警数量
                jl_baojingshuliang = new JLabel("报警数量:");
                jl_baojingshuliang.setBounds(10, 130, 60, 25);
                jt_baojingshuliang = new JTextField();
                jt_baojingshuliang.setBounds(80, 130, 240, 25);
                jp_north.add(jl_baojingshuliang);
                jp_north.add(jt_baojingshuliang);
                //销售价格
                jl_xiaoshoujiage = new JLabel("销售价格:");
                jl_xiaoshoujiage.setBounds(380, 130, 60, 25);
                jt_xiaoshoujiage= new JTextField();
                jt_xiaoshoujiage.setBounds(450, 130, 80, 25);
                jp_north.add(jl_xiaoshoujiage);
                jp_north.add(jt_xiaoshoujiage);
                // 会员价格
                jl_huiyuanjiage = new JLabel("会员价格:");
                jl_huiyuanjiage.setBounds(540, 130, 60, 25);
                jt_huiyuanjiage = new JTextField();
                jt_huiyuanjiage.setBounds(609, 130, 80, 25);
                jp_north.add(jl_huiyuanjiage);
                jp_north.add(jt_huiyuanjiage);

                // 库存量
                jl_kucunshuliang = new JLabel("库存数量:");
                jl_kucunshuliang.setBounds(10, 200, 60, 25);
                jt_kucunshuliang = new JTextField();
                jt_kucunshuliang.setBounds(80, 200, 240, 25);
                jt_kucunshuliang.setEditable(false);
                jp_north.add(jl_kucunshuliang);
                jp_north.add(jt_kucunshuliang);

                jp_jinhuo.add(jp_north,BorderLayout.NORTH);
            }
            // 下半部分
            {
                jp_south = new JPanel();
                jp_south.setLayout(null);
                jp_south.setPreferredSize(new Dimension(710, 200));
                // 流水号
                jl_liushuihao = new JLabel("进货流水号:");
                jl_liushuihao.setBounds(10, 10, 70, 25);
                jt_liushuihao = new JTextField();
                jt_liushuihao.setEditable(false);
                jt_liushuihao.setBounds(90, 10, 250, 25);
                jp_south.add(jl_liushuihao);
                jp_south.add(jt_liushuihao);
                // 供货商
                jl_gonghuoshang = new JLabel("供货商:");
                jl_gonghuoshang.setBounds(370, 10, 50, 25);
                jc_gonghuoshang = new JComboBox(daopd.selectCname().toArray());
                jc_gonghuoshang.setBounds(430, 10, 260, 25);
                jp_south.add(jl_gonghuoshang);
                jp_south.add(jc_gonghuoshang);
                // 进货数量
                jl_jinhuoshuliang = new JLabel("进货数量:");
                jl_jinhuoshuliang.setBounds(10, 70, 70, 25);
                jt_jinhuoshuliang = new JTextField();
                jt_jinhuoshuliang.setBounds(90, 70, 250, 25);
                jp_south.add(jl_jinhuoshuliang);
                jp_south.add(jt_jinhuoshuliang);
                // 进货价格
                jl_jinhuojiage= new JLabel("进货价格:");
                jl_jinhuojiage.setBounds(370, 70, 60, 25);
                jt_jinhuojiage  = new JTextField();
                jt_jinhuojiage.addMouseListener(this);
                jt_jinhuojiage.setBounds(430, 70, 260, 25);
                jp_south.add(jl_jinhuojiage);
                jp_south.add(jt_jinhuojiage);
                // 确定、清空按钮
                jb_queding  = new JButton("确定");
                jb_queding.addActionListener(this);
                jb_qingkong = new JButton("清空");
                jb_qingkong.addActionListener(this);
                jb_queding.setBounds(280,135,70,25);
                jb_qingkong.setBounds(370,135,70,25);
                jp_south.add(jb_qingkong);
                jp_south.add(jb_queding);

                jp_jinhuo.add(jp_south,BorderLayout.SOUTH);

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==jb_queding){
          // 拿到所有框的内容
            String gId = jt_shangpinguanli.getText();
            String gName = jt_shangpinmingcheng.getText();
            String gSpec = jt_dengjiguige.getText();
            String gMinNUmber = jt_baojingshuliang.getText();
            String salePrice = jt_xiaoshoujiage.getText();
            String vipPrice = jt_huiyuanjiage.getText();
            String inStoreAmount = jt_jinhuoshuliang.getText();
            String purchasePrice = jt_jinhuojiage.getText();
            String gAmount = jt_kucunshuliang.getText();
            String inStoreId = jt_liushuihao.getText();
            String cname = (String) jc_suoshuleibie.getSelectedItem();
            String gUname = (String) jc_jiliangdanwei.getSelectedItem();
            String gpname = (String) jc_gonghuoshang.getSelectedItem();
            //进行判断，所有空都不为空时，按确定可以添加数据到数据库
            if (!gName.equals("")&&!gId.equals("")&&!gSpec.equals("")&&
                    !gMinNUmber.equals("") &&!salePrice.equals("")&&
                    !vipPrice.equals("")&&!inStoreAmount.equals("")&&
                    !purchasePrice.equals("")&&!gAmount.equals("")&&
                    !inStoreId.equals("")) {
                // 如果库存量为空时，则说明该商品是第一次进货，则库存量为进货量
                int gAmount_int = Integer.parseInt(gAmount);
                if (gAmount_int==0) {
                    //点击按钮之后，先调用供货商的插入方法，最后调用货物的插入方法
                    //1.创建供货对象和供货商对象
                    Instore is = new Instore(inStoreId, Integer.parseInt(inStoreAmount), Double.parseDouble(purchasePrice));
                    GoodsPrivoder gpd = new GoodsPrivoder(gpname);
                    boolean a= daois.southInsert(is, gpd,gId);
                    //2.更改库存 库存就是进货量
                    String nowgAmount = jt_jinhuoshuliang.getText();
                    //3.创建货物对象
                    Goods gd = new Goods(gId, daogdc.selectCid(cname), daogdut.selectgUid(gUname), gName, gSpec, Integer.parseInt(gMinNUmber), Double.parseDouble(salePrice),Double.parseDouble(vipPrice), Integer.parseInt(nowgAmount));
                    boolean b = daogoods.northInsert(gd);
                    if (a && b) {
                        JOptionPane.showMessageDialog(null, "插入成功");
                    } else {
                        JOptionPane.showMessageDialog(null, "插入失败，请检查信息是否正确");
                    }

                }else{
                    // 此时库存不为空，需要更改数据库
                    //1.利用selectByGid方法获取instore对象,并更改数据
//                    Instore is = daois.selectByGid(gId);
                    Instore is = new Instore(Integer.parseInt(inStoreAmount),Double.parseDouble(purchasePrice),gId);
                    boolean a = daois.updateBygpid(is,gId);

                    //2.更改库存  现在的库存是原有的加进货
                    String nowgAmount =  String.valueOf(Integer.parseInt(inStoreAmount)+Integer.parseInt(gAmount));

                    //3.创建goods对象
                    Goods gd = new Goods(gName,gId,Integer.parseInt(gMinNUmber),Double.parseDouble(salePrice),Double.parseDouble(vipPrice),Integer.parseInt(nowgAmount));
                    boolean b = daogoods.updateByGid(gd);
                    if (a&&b) {
                        JOptionPane.showMessageDialog(null, "更改成功");
                    }else{
                        JOptionPane.showMessageDialog(null,"更改失败，请检查信息是否正确");
                    }
                }
           }else{
                JOptionPane.showMessageDialog(null,"请检查信息是否完整");
            }

        }
        if (source==jb_qingkong){
            // 清空数据
            jt_shangpinguanli.setText("");
            jt_shangpinmingcheng.setText("");
            jt_dengjiguige.setText("");
            jt_baojingshuliang.setText("");
            jt_xiaoshoujiage.setText("");
            jt_huiyuanjiage.setText("");
            jt_jinhuoshuliang.setText("");
            jt_jinhuojiage.setText("");
            jt_liushuihao.setText("");
            jt_kucunshuliang.setText("");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if(source==jt_dengjiguige) {
           //点击规格文本框之后就显示库存，之前没有进的货物就显示0
            //1.获取数据
            String gId = jt_shangpinguanli.getText();
            String gName = jt_shangpinmingcheng.getText();
            //2.调用显示库存的方法
            String n = String.valueOf(daogoods.inStock(gId, gName));
            jt_kucunshuliang.setText(n);
            //调用生成流水号的方法
            jt_liushuihao.setText(getTime());
        }
//        if(source==jt_jinhuojiage){
//           jt_liushuihao.setText("空");
//        }

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
