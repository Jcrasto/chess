package gamePlay;

import org.junit.jupiter.api.Test;

public class PgnStringReaderTest {

    @Test
    public void StringReadTest(){
        String gameString = "1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 g6 6.g3 Nc6 7.Nde2 Bg7 8.Bg2 Kf8 9.O-O Bd7 10.h3 a5 11.a4 Nb4 12.Nd5 Bc6 13.c3 Na6 14.Bg5 Nc5 15.Qc2 1/2-1/2";
        //gameString = "1.e4 c5 2.Nf3 e6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 d6 6.g3 Be7 7.Bg2 O-O 8.O-O Nc69.Re1 Bd7 10.Be3 Ne5 11.Qe2 Rc8 12.Rad1 Nc4 13.Bc1 Qb6 14.b3 Qa5 15.bxc4 Qxc316.Nb5 Bxb5 17.cxb5 Qxc2 18.e5 dxe5 19.Bxb7 Qxe2 20.Rxe2 Rb8 21.Bc6 Bc5 22.Bb2 Rfd823.Rxd8+ Rxd8 24.Bxe5 Ng4 25.Bc7 Rc8 26.Bf4 Rd8 27.Kg2 Kf8 28.h3 Nf6 29.Rc2 Bb630.a4 Ke7 31.Bd2 Nd5 32.a5 Bd4 33.Bc1 e5 34.b6 axb6 35.a6 Ke6 36.Ba3 Nc737.Bb7 Nb5 38.Bc8+ Kd5 39.Bb7+ Ke6 40.Bc8+ Kd5 41.Be7 Re8 42.Bb4 Rd8 43.Bb7+ Ke6 44.f4 f6 45.Kf3 g6 46.Rc1 h5 47.h4 Kf7 48.Rd1 Ke6 49.fxe5 fxe5 50.Ke4 Na7 51.Rd3 Rd7 52.Ba3 Rc7 53.Bd5+ Kd7 54.Rf3 Rc2 55.Rf7+ Kd8 56.Be6 b5 57.Bd6 Rf2 58.Rg7  1-0";
        //gameString = "1.d4 Nf6 2.Nf3 g6 3.c4 c5 4.d5 b5 5.cxb5 a6 6.bxa6 Bg7 7.Nc3 Bxa6 8.e4 Bxf19.Kxf1 d6 10.g3 O-O 11.Kg2 Nbd7 12.Re1 Qb6 13.Re2 Rfb8 14.Bf4 Ng4 15.Rc1 Nde516.Nxe5 Nxe5 17.b3 Qa6 18.Bxe5 Bxe5 19.Nb1 Rb4 20.Rec2 c4 21.bxc4 Rxc4 22.Qd3 Rxc223.Qxa6 Rxa6 24.Rxc2 f5 25.f3 Kf7 26.Kf2 h5 27.Ke3 h4 28.gxh4 fxe4 29.fxe4 Bf630.Kf4 Bxh4 31.Nd2 Ra4 32.Nc4 Bf6 33.Ke3 Ra8 34.Kd3 Rh8 35.Ke3 Bg5+ 36.Kf3 Ra837.a3 Ra4 38.Ke2 Bf4 39.h3 Ra8 40.Rc3 Kf6 41.Rf3 g5 42.Kd3 Ra6 43.Kc2 e644.Rd3 exd5 45.Rxd5 Ke6 46.Kb3 Kd7 47.e5 Bxe5 48.Nxe5+ Ke6 49.Nd3 Rxa3+ 50.Kxa3 Kxd551.Nb4+ Ke4 52.Nc6 Kf4 53.Nd4 Kg3  1/2-1/2";
        //gameString = "1.Nf3 c5 2.c4 Nc6 3.d4 cxd4 4.Nxd4 g6 5.e4 Bg7 6.Be3 Nf6 7.Nc3 d6 8.Be2 O-O9.O-O Bd7 10.Nc2 a5 11.f3 Be6 12.Qd2 Nd7 13.Rac1 Nc5 14.Rfd1 a4 15.Na3 Qa516.Nd5 Bxd5 17.cxd5 Qxd2 18.Rxd2 Nb4 19.Bxc5 dxc5 20.Ra1 f5 21.Bc4 Kh8 22.Re1 fxe423.Rxe4 Bf6 24.Nb5 Rfd8 25.Re6 Nc6 26.d6 Kg7 27.Re4 exd6 28.Nc7 Nd4 29.Nxa8 Rxa830.Bd5 Rb8 31.Rd1 b5 32.b3 a3 33.Rd2 b4 34.Bc4 d5 35.Bxd5 Rd8 36.Bc4 Nxf3+37.gxf3 Rxd2 38.Re2 Rd1+ 39.Kf2 Ra1 40.Kg3 Bb2 41.Re7+ Kf8 42.Rf7+ Ke8 43.Rxh7 Rxa244.Ra7 Bc3  0-1";
        PgnStringReader reader = new PgnStringReader(gameString);
    }

}
