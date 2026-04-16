package raffaele.u5w2d1.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import raffaele.u5w2d1.entities.Autore;
import raffaele.u5w2d1.execptionnn.NotFoundException;
import raffaele.u5w2d1.payload.AutoreDTO;
import raffaele.u5w2d1.payload.PayloadAutore;
import raffaele.u5w2d1.repositori.AutoreRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class AutoreService {

    private final AutoreRepository autoreRepository;
    private final Cloudinary cloudinary;

    @Autowired
    public AutoreService(AutoreRepository autoreRepository,Cloudinary cloudinary) {
        this.autoreRepository = autoreRepository;
        this.cloudinary=cloudinary;
    }

    public List<Autore> findAll() {
        return this.autoreRepository.findAll();
    }

    public Autore salvaAutore(AutoreDTO body) {
        Autore newAutore = new Autore(body.nome(), body.cognome(), body.email(), body.nascita(), body.avatar());

        newAutore.setAvatar("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());

        return this.autoreRepository.save(newAutore);
    }

    public Autore findById(long id) {
        return this.autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Autore con id " + id + " non trovato"));
    }

    public Autore findByIdAndUpdate(long id, PayloadAutore body) {
        Autore found = findById(id);

        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setNascita(body.getNascita());
        found.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());

        return this.autoreRepository.save(found);
    }

    public void findByIdAndDelete(long id) {
        Autore found = findById(id);
        this.autoreRepository.delete(found);
    }
// qui ci devo mette l'upload di clodinary
    public void avatarupload(MultipartFile file, long AutoreId){
        try{

            Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = (String) result.get("secure_url");
            System.out.println(url);

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}