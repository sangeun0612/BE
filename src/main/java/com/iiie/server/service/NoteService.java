package com.iiie.server.service;
import com.iiie.server.domain.Note;
import com.iiie.server.domain.Caregiver;
import com.iiie.server.domain.Guardian;
import com.iiie.server.exception.NotFoundException;
import com.iiie.server.repository.NoteRepository;
import com.iiie.server.repository.CareGiverRepository;
import com.iiie.server.repository.GuardianRepository;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NoteService {

    private final NoteRepository noteRepository;
    private final CareGiverRepository caregiverRepository;
    private final GuardianRepository guardianRepository;

    public NoteService(NoteRepository noteRepository,
                       CareGiverRepository careGiverRepository,
                       GuardianRepository guardianRepository) {
        this.noteRepository = noteRepository;
        this.caregiverRepository = careGiverRepository;
        this.guardianRepository = guardianRepository;
    }

    @Transactional
    public Note addNote(Long caregiverId, Long guardianId, String noteContent) {
        Caregiver caregiver = caregiverRepository.findById(caregiverId)
                .orElseThrow(() -> new NotFoundException("caregiver", caregiverId, "존재하지 않는 간병인입니다."));
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() -> new NotFoundException("guardian", guardianId, "존재하지 않는 보호자입니다."));

        Note note = Note.builder()
                .caregiver(caregiver)
                .guardian(guardian)
                .noteContent(noteContent)
                .build();
        return noteRepository.save(note);
    }

    @Transactional
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    @Transactional
    public Note copyNote(Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new NotFoundException("note", noteId, "존재하지 않는 쪽지입니다."));
        String noteContent = note.getNoteContent();
        StringSelection stringSelection = new StringSelection(noteContent);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        return note;
    }

    public Note getNotes(Long caregiverId, Long guardianId) {
    }
}